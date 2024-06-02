using System;
using System.Management;
using System.Data.OleDb;
using System.Net;
using System.Net.Sockets;
using System.IO;

namespace InfoPC
{
    class Program
    {
        static void Main(string[] args)
        {
            String path = Environment.CurrentDirectory + "\\config.txt";
            String connectionString = new StreamReader(path).ReadLine();

            String tip = "";
            String os = "";
            String framework = "";
            String cpu = "";
            String gpu = "";
            String ram = "";
            String hd = "";
            String dIns = "";
            String dAcq = "";
            String loc = "";
            String user = "";
            String ip = "";

            #region Acquisisco i dati della macchina

            // Sistema operativo corrente
            ManagementObjectSearcher searcher = new ManagementObjectSearcher("select * from Win32_OperatingSystem");
            foreach (ManagementObject mo in searcher.Get())
            {
                os = mo["Caption"].ToString();
            }

            // Versione Framework
            framework = System.Environment.Version.ToString();

            // Nome CPU
            searcher.Query.QueryString = "select * from Win32_Processor";
            foreach (ManagementObject mo in searcher.Get())
            {
                cpu = mo["Name"].ToString();
            }

            // Nome GPU
            searcher.Query.QueryString = "select * from Win32_VideoController";
            foreach (ManagementObject mo in searcher.Get())
            {
                gpu = mo["Description"].ToString();
            }

            // Memoria RAM
            searcher.Query.QueryString = "select * from Win32_PhysicalMemory";
            foreach (ManagementObject mo in searcher.Get())
            {
                ram = mo["Capacity"].ToString();
            }

            // Capacità Hard Disk
            searcher.Query.QueryString = "select * from Win32_DiskDrive";
            foreach (ManagementObject mo in searcher.Get())
            {
                hd = mo["Size"].ToString();
                Console.WriteLine("-------------" + hd);
                break;
            }

            // Utente
            user = System.Environment.UserName;

            // IP
            IPAddress[] localIPs = Dns.GetHostAddresses(Dns.GetHostName());
            foreach (IPAddress addr in localIPs)
            {
                if (addr.AddressFamily == AddressFamily.InterNetwork)
                {
                    ip = addr.ToString();
                }
            }
            #endregion

            Console.WriteLine(os);
            Console.WriteLine(framework);
            Console.WriteLine(cpu);
            Console.WriteLine(gpu);
            Console.WriteLine(ram);
            Console.WriteLine(hd);
            Console.WriteLine(user);
            Console.WriteLine(ip);

            #region Imposto indici di OS, CPU e GPU

            string[] s = new string[] { "os", "cpu", "gpu" };
            string[] v = new string[] { os, cpu, gpu };

            for (int i = 0; i < 3; i++)
            {
                bool exist = false;
                try
                {
                    OleDbConnection connection = new OleDbConnection(connectionString);
                    String query = "SELECT * FROM " + s[i] + " WHERE valore = '" + v[i] + "';";
                    OleDbCommand command = new OleDbCommand(query, connection);
                    connection.Open();
                    OleDbDataReader reader = command.ExecuteReader();
                    if (reader.HasRows)
                    {
                        exist = true;
                    }
                    connection.Close();

                    // Se l'elemento non esiste
                    if (!exist)
                    {
                        // Lo creo
                        connection = new OleDbConnection(connectionString);
                        query = "INSERT INTO " + s[i] + " (valore)  VALUES ( + '" + v[i] + "');";
                        command = new OleDbCommand(query, connection);
                        connection.Open();
                        command.ExecuteNonQuery();
                        connection.Close();
                    }

                    // Prendo il suo id
                    connection = new OleDbConnection(connectionString);
                    query = "SELECT * FROM " + s[i] + " WHERE valore = '" + v[i] + "';";
                    command = new OleDbCommand(query, connection);
                    connection.Open();
                    reader = command.ExecuteReader();
                    reader.Read();
                    v[i] = reader.GetInt32(0).ToString();
                    connection.Close();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Errore query in Query.Insert() " + s[i]);
                    Console.WriteLine(ex.Message.ToString());
                }
            }
            #endregion

            try
            {
                OleDbConnection connection = new OleDbConnection(connectionString);
                String query = "SELECT * FROM tipologia";
                OleDbCommand command = new OleDbCommand(query, connection);
                connection.Open();
                OleDbDataReader reader = command.ExecuteReader();

                Console.WriteLine("\nSeleziona la tipologia: ");
                while (reader.Read())
                {
                    Console.WriteLine(reader.GetInt32(0) + " - " + reader.GetString(1));
                }

                tip = Console.ReadLine();

                connection.Close();

                connection = new OleDbConnection(connectionString);
                query = "SELECT * FROM locazione";
                command = new OleDbCommand(query, connection);
                connection.Open();
                reader = command.ExecuteReader();

                Console.WriteLine("\nSeleziona la locazione: ");
                while (reader.Read())
                {
                    Console.WriteLine(reader.GetInt32(0) + " - " + reader.GetString(1));
                }

                loc = Console.ReadLine();

                connection.Close();
            }
            catch (Exception e)
            {
                Console.WriteLine("Errore query: " + e.Message.ToString());
            }

            Console.WriteLine("\nData Inserimento dd/mm/yyyy: ");
            dIns = Console.ReadLine();

            Console.WriteLine("\nData Acquisto dd/mm/yyyy: ");
            dAcq = Console.ReadLine();

            #region Inserisco record
            String desc;
            Console.WriteLine("\nInserisci descrizione: ");
            desc = Console.ReadLine();

            OleDbConnection conn = new OleDbConnection(connectionString);
            String q = "INSERT INTO InventarioHW (valore, id_tipologia, id_OS, framework, id_cpu, id_gpu, ram, hd, dataInserimento, dataAcquisto, id_locazione, utente, ip) VALUES (";
            q += "'" + desc + "', ";
            q += tip + ", ";
            q += v[0] + ", ";
            q += "'" + framework + "', ";
            q += v[1] + ", ";
            q += v[2] + ", ";
            q += "'" + (Int64.Parse(ram) / 1024 / 1024 / 1024) + "', ";
            q += "'" + (Int64.Parse(hd) / 1024 / 1024 / 1024) + "', ";
            q += "'" + dIns + "', ";
            q += "'" + dAcq + "', ";
            q += loc + ", ";
            q += "'" + user + "', ";
            q += "'" + ip + "');";
            OleDbCommand comm = new OleDbCommand(q, conn);
            conn.Open();
            comm.ExecuteNonQuery();
            conn.Close();
            #endregion

            Console.WriteLine("\nPremi un tasto per terminare...");
            Console.ReadLine();
        }
    }
}
