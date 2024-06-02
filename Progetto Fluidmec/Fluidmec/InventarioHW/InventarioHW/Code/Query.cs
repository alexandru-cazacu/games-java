using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace InventarioHW
{
    public enum Operation
    {
        Search,
        Add,
        Change,
        Delete
    };

    class Query
    {
        public static String CONNECTION_STRING = "Provider=MySQLProv;Data Source = C:\\Users\\s.ced\\Desktop\\InventarioHW.accdb";
        public static String DEFAULT_QUERY = "SELECT InventarioHW.id_inventarioHW, InventarioHW.descrizione, Tipologia.descrizione, Marca.descrizione, CPU.descrizione, InventarioHW.ram, InventarioHW.hd, OS.descrizione, Locazione.descrizione, InventarioHW.utente, InventarioHW.dataInserimento, InventarioHW.dataAcquisto FROM((((InventarioHW INNER JOIN Locazione ON InventarioHW.id_locazione = Locazione.id_locazione) INNER JOIN Marca ON InventarioHW.id_marca = Marca.id_marca) LEFT JOIN OS ON InventarioHW.id_OS = OS.id_OS) INNER JOIN Tipologia ON InventarioHW.id_tipologia = Tipologia.id_tipologia) LEFT JOIN CPU ON InventarioHW.id_CPU = CPU.id_CPU ";

        private OleDbConnection connection = new OleDbConnection();
        private OleDbDataAdapter adapter = new OleDbDataAdapter();
        private OleDbCommand command = new OleDbCommand();
        private DataTable dataTable = new DataTable();

        /// <summary>
        /// Inserisce un record in una delle tabelle derivate
        /// (che hanno solo id e descrizione)
        /// </summary>
        /// <param name="table">La tabella dove bisogna inserire il valore</param>
        /// <param name="value">Il valore che verrà inserito</param>
        /// <returns></returns>
        public static bool Insert(String table, String value)
        {
            try
            {
                // Si connette ed inserirsce la stringa
                OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                connection.Open();
                String query = "INSERT INTO " + table + " (descrizione)  VALUES ( + '" + value + "');";
                OleDbCommand command = new OleDbCommand(query, connection);
                command.ExecuteNonQuery();
                connection.Close();

                // Ritorna operazione positiva
                return true;
            }
            catch (Exception ex)
            {
                // Eventuali errori
                Console.WriteLine("Errore query in Query.Insert();");
                Console.WriteLine(ex.Message.ToString());
                // Ritorna operazione negativa
                return false;
            }

        }

        /// <summary>
        /// Elimina un certo record in una tabella
        /// </summary>
        /// <param name="tab">La tabella dove si andrà ad eliminare il record</param>
        /// <param name="rowIndex">L'indice del record da eliminare</param>
        /// <returns></returns>
        public static bool Delete(String table, int rowIndex)
        {
            try
            {
                // Si connette ed elimina il record
                OleDbConnection connection = new OleDbConnection(Query.CONNECTION_STRING);
                OleDbCommand command = new OleDbCommand("DELETE FROM " + table + " WHERE id_" + table + " = " + rowIndex, connection);

                connection.Open();
                command.ExecuteNonQuery();
                connection.Close();

                // Ritorna oerazione positiva
                return true;

            }
            catch (Exception ex)
            {
                // Eventuali errori
                Console.WriteLine("Errore query in Query.Delete();");
                Console.WriteLine(ex.Message.ToString());
                // Ritorna operazione negativa
                return false;
            }
        }

        /// <summary>
        /// Seleziona i record di una tabella da inserire in un DataGridView
        /// </summary>
        /// <param name="dataGrid">La DataGridView dove i paramentri saranno visualizzati</param>
        /// <param name="table">La tabella che si vuole visualizzare</param>
        /// <returns></returns>
        public static bool Select(DataGridView dataGrid, String table)
        {
            // Se la tebella è la principale
            if (table == "InventarioHW")
            {
                try
                {
                    // Si connette e richiede i dati
                    DataSet dataSet = new DataSet();
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Uso la DEFAULT_QUERY per poter visualizzare eventuali relazioni
                    OleDbDataAdapter adapter = new OleDbDataAdapter(DEFAULT_QUERY, connection);
                    connection.Open();
                    adapter.Fill(dataSet);
                    connection.Close();
                    dataGrid.DataSource = dataSet.Tables[0];

                    // Imposta i titoli delle colonne
                    dataGrid.Columns[0].HeaderText = "Codice";
                    dataGrid.Columns[1].HeaderText = "Descrizione";
                    dataGrid.Columns[2].HeaderText = "Tipologia";
                    dataGrid.Columns[3].HeaderText = "Marca";
                    dataGrid.Columns[4].HeaderText = "CPU";
                    dataGrid.Columns[5].HeaderText = "RAM";
                    dataGrid.Columns[6].HeaderText = "HD";
                    dataGrid.Columns[7].HeaderText = "OS";
                    dataGrid.Columns[8].HeaderText = "Locazione";
                    dataGrid.Columns[9].HeaderText = "Utente";
                    dataGrid.Columns[10].HeaderText = "Inserimento";
                    dataGrid.Columns[11].HeaderText = "Acquisto";

                    // Ritorna operazione positiva
                    return true;
                }
                catch (Exception ex)
                {
                    // Eventuali errori
                    Console.WriteLine("Errore query in Query.Select() tabella primaria;");
                    Console.WriteLine(ex.Message.ToString());
                    // Ritorna operazione negativa
                    return false;
                }
            }

            // Altrimenti seleziona una delle altre tabelle
            else
            {
                try
                {
                    // Si connette e seleziona la tabella
                    DataSet dataSet = new DataSet();
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    OleDbDataAdapter adapter = new OleDbDataAdapter("SELECT * FROM " + table, connection);
                    connection.Open();
                    adapter.Fill(dataSet);
                    connection.Close();
                    dataGrid.DataSource = dataSet.Tables[0];

                    // Per ogni colonna
                    for (int i = 0; i < dataGrid.ColumnCount; i++)
                    {
                        // Il titolo della colonna diventa il nome della colonna
                        dataGrid.Columns[i].HeaderText = dataSet.Tables[0].Columns[i].ColumnName.ToUpper();
                    }

                    // Ritorna operazione positiva
                    return true;
                }
                catch (Exception ex)
                {
                    // Eventuali errori
                    Console.WriteLine("Errore query in Query.Select() tabelle derivate;");
                    Console.WriteLine(ex.Message.ToString());
                    // Ritorna operazione negativa
                    return false;
                }
            }
        }

    }
}
