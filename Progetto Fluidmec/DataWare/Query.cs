using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DataWare
{
    class Query
    {
        public static String CONNECTION_STRING = "Provider = Microsoft.ACE.OLEDB.12.0; Data Source = F:\\FLUIDMEC\\Progetto Fluidmec\\InventarioHW.accdb";

        /// <summary>
        /// Inserisce un record all'interno di una tabella, dato il suo nome e i valori da inserire
        /// </summary>
        /// <param name="table">La tabella dove si andrà ad inserire il record</param>
        /// <param name="values">I valori del record</param>
        /// <returns>Ritorna true se l'operazione si è conclusa con successo, false altrimenti</returns>
        public static Boolean Insert(String table, String[] values)
        {
            // Se la tabella è quella dell'InventarioHW
            if (table == "InventarioHW")
            {
                try
                {
                    // Dichiaro OleDbConnection al databse
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Imposto la query
                    String query = "INSERT INTO InventarioHW (valore, id_tipologia, id_OS, framework, id_CPU, id_GPU, ram, hd, dataInserimento, dataAcquisto, id_locazione, utente, ip) VALUES (";
                    // Valore
                    query += "'" + values[0] + "', ";
                    // id_tipologia
                    query += values[1] + ", ";
                    // id_OS
                    query += values[2] + ", ";
                    // framework
                    query += "'" + values[3] + "', ";
                    // id_CPU
                    query += values[4] + ", ";
                    // id_GPU
                    query += values[5] + ", ";
                    // ram
                    query += "'" + values[6] + "', ";
                    // hd
                    query += "'" + values[7] + "', ";
                    // dataInserimento
                    query += "'" + values[8] + "', ";
                    // dataAcquisto
                    query += "'" + values[9] + "', ";
                    // id_locazione
                    query += values[10] + ", ";
                    // utente
                    query += "'" + values[11] + "',";
                    // ip
                    query += "'" + values[12] + "');";
                    // Dichiato OleDbCommand con la query e la connessione
                    OleDbCommand command = new OleDbCommand(query, connection);
                    // Apro la connessione
                    connection.Open();
                    // Eseguo il comando
                    command.ExecuteNonQuery();
                    // Chiudo la connessione
                    connection.Close();

                    // Operazione conclusa con successo
                    return true;
                }
                catch (Exception ex)
                {
                    // Info sul tipo di errore
                    Console.WriteLine("Query.Insert(): " + ex.Message);
                    // Operazione fallita
                    return false;
                }
            }
            // Se è una delle altre tabelle
            else
            {
                try
                {
                    // Dichiaro OleDbConnection al databse
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Imposto la query
                    String query = "INSERT INTO " + table + " (valore) VALUES (";
                    for (int i = 0; i < values.Length; i++)
                    {
                        query += "'" + values[i] + "',";
                    }
                    query = query.Remove(query.Length - 1);
                    query += ");";
                    // Dichiato OleDbCommand con la query e la connessione
                    OleDbCommand command = new OleDbCommand(query, connection);
                    // Apro la connessione
                    connection.Open();
                    // Eseguo il comando
                    command.ExecuteNonQuery();
                    // Chiudo la connessione
                    connection.Close();

                    // Operazione conclusa con successo
                    return true;
                }
                catch (Exception ex)
                {
                    // Info sul tipo di errore
                    Console.WriteLine("Query.Insert(): " + ex.Message);
                    // Operazione fallita
                    return false;
                }
            }
        }

        /// <summary>
        /// Modifica un record all'interno di una tabella, dato il suo nome, l'id e i valori da inserire
        /// </summary>
        /// <param name="table">La tabella dove si andrà a modificare il record</param>
        /// <param name="id">L'id del record da modificare</param>
        /// <param name="values">I valori del record</param>
        /// <returns>Ritorna true se l'operazione si è conclusa con successo, false altrimenti</returns>
        public static Boolean Update(String table, int id, String[] values)
        {
            // Se la tabella è la principale
            if (table == "InventarioHW")
            {
                try
                {
                    // Dichiaro OleDbConnection al database
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Imposto la query
                    String query = "UPDATE inventarioHW ";
                    // Valore
                    query += "SET valore = '" + values[0] + "', ";
                    // id_tipologia
                    query += "id_tipologia = " + values[1] + ", ";
                    // id_OS
                    query += "id_OS = " + values[2] + ", ";
                    // framework
                    query += "framework = '" + values[3] + "', ";
                    // id_CPU
                    query += "id_CPU = " + values[4] + ", ";
                    // id_GPU
                    query += "id_GPU = " + values[5] + ", ";
                    // ram
                    query += "ram = '" + values[6] + "', ";
                    // hd
                    query += "hd = '" + values[7] + "', ";
                    // dataInserimento
                    query += "dataInserimento = '" + values[8] + "', ";
                    // dataAcquisto
                    query += "dataAcquisto = '" + values[9] + "', ";
                    // id_locazione
                    query += "id_locazione = " + values[10] + ", ";
                    // utente
                    query += "utente = '" + values[11] + "',";
                    // ip
                    query += "ip = '" + values[12] + "' WHERE id_inventarioHW = " + id + ";";
                    // Dichiato OleDbCommand con la query e la connessione
                    OleDbCommand command = new OleDbCommand(query, connection);
                    // Apro la connessione
                    connection.Open();
                    // Eseguo la query
                    command.ExecuteNonQuery();
                    // Chiudo la connessione
                    connection.Close();

                    // Operazione conclusa con successo
                    return true;
                }
                catch (Exception ex)
                {
                    // Info sul tipo di errore
                    Console.WriteLine("Query.Update(): " + ex.Message);
                    // Operazione fallita
                    return false;
                }
            }
            // Altrimenti se è una delle altre tabelle
            else
            {
                try
                {
                    // Dichiaro OleDbConnection al database
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Imposto la query
                    String query = "UPDATE " + table;
                    // Valore
                    query += " SET valore = '" + values[0] + "' WHERE id_" + table + " = " + id + ";";
                    // Dichiato OleDbCommand con la query e la connessione
                    OleDbCommand command = new OleDbCommand(query, connection);
                    // Apro la connessione
                    connection.Open();
                    // Eseguo la query
                    command.ExecuteNonQuery();
                    // Chiudo la connessione
                    connection.Close();

                    // Operazione conclusa con successo
                    return true;
                }
                catch (Exception ex)
                {
                    // Info sul tipo di errore
                    Console.WriteLine("Query.Update(): " + ex.Message);
                    // Operazione fallita
                    return false;
                }
            }
        }

        /// <summary>
        /// Elimina un record di una tabella dato il suo id
        /// </summary>
        /// <param name="table">Il nome della tabella all'interno del database</param>
        /// <param name="id">L'id della riga da eliminare</param>
        /// <returns>Ritorna true se l'operazione si è conclusa con successo, false altrimenti</returns>
        public static Boolean Delete(String table, int id)
        {
            try
            {
                // Dichiato OleDbConnection con il database
                OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                // Imposto la query per eliminare la riga
                String query = "DELETE FROM " + table + " WHERE id_" + table + " = " + id;
                // Dichiato OleDbCommand con la query e la connessione
                OleDbCommand command = new OleDbCommand(query, connection);
                // Apro la connessione
                connection.Open();
                // Eseguo il comando
                command.ExecuteNonQuery();
                // Chiudo la connessione
                connection.Close();

                // Operazione conclusa con successo
                return true;
            }
            catch (Exception ex)
            {
                // Info sul tipo di errore
                Console.WriteLine("Query.Delete(): " + ex.Message);
                // Operazione fallita
                return false;
            }
        }

        /// <summary>
        /// Riempie una DataGridView con i dati contenuti in una tabella del database
        /// </summary>
        /// <param name="table">Il nome della tabella all'interno del Database</param>
        /// <param name="dataGrid">La DataGridView che verrà riempita</param>
        /// <returns>Ritorna true se l'operazione si è conclusa con successo, false altrimenti</returns>
        public static Boolean Select(String table, DataGridView dataGrid)
        {
            // Se la tabella è quella principale
            if (table == "InventarioHW")
            {
                try
                {
                    // Resetto la griglia
                    dataGrid.DataSource = null;
                    // Dichiaro DataSet
                    DataSet dataSet = new DataSet();
                    // Dichiaro OleDbConnection al file del database
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Dichiaro OleDbAdapter
                    OleDbDataAdapter adapter = new OleDbDataAdapter("SELECT InventarioHW.id_inventarioHW, InventarioHW.valore, Tipologia.valore, OS.valore, InventarioHW.framework, CPU.valore, GPU.valore, InventarioHW.ram, InventarioHW.hd, InventarioHW.dataInserimento, InventarioHW.dataAcquisto, Locazione.valore, InventarioHW.utente, InventarioHW.ip FROM((((InventarioHW LEFT JOIN Tipologia ON InventarioHW.id_tipologia = Tipologia.id_tipologia) LEFT JOIN Locazione ON InventarioHW.id_locazione = Locazione.id_locazione) LEFT JOIN OS ON InventarioHW.id_OS = OS.id_OS) LEFT JOIN CPU ON InventarioHW.id_CPU = CPU.id_CPU) LEFT JOIN GPU ON InventarioHW.id_GPU = GPU.id_GPU;", connection);
                    // Apro la connessione
                    connection.Open();
                    // Prendo i dati
                    adapter.Fill(dataSet);
                    // Chiudo la connessione
                    connection.Close();
                    // Copio i dati nella DataGridView prendoli dalla prima tabella
                    dataGrid.DataSource = dataSet.Tables[0];
                    // Aggiorno la grafica della griglia
                    dataGrid.Refresh();

                    // Operazione conclusa con successo
                    return true;
                }
                catch (Exception ex)
                {
                    // Info sul tipo di errore
                    Console.WriteLine("Query.Select(): " + ex.Message);
                    // Operazione fallita
                    return false;
                }
            }
            // Se è una delle altre tabelle
            else
            {
                try
                {
                    // Resetto la griglia
                    dataGrid.DataSource = null;
                    // Dichiaro DataSet
                    DataSet dataSet = new DataSet();
                    // Dichiaro OleDbConnection al file del database
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Dichiaro OleDbAdapter
                    OleDbDataAdapter adapter = new OleDbDataAdapter("SELECT * FROM " + table, connection);
                    // Apro la connessione
                    connection.Open();
                    // Prendo i dati
                    adapter.Fill(dataSet);
                    // Chiudo la connessione
                    connection.Close();
                    // Copio i dati nella DataGridView prendoli dalla prima tabella
                    dataGrid.DataSource = dataSet.Tables[0];
                    // Aggiorno la grafica della griglia
                    dataGrid.Refresh();

                    // Operazione conclusa con successo
                    return true;
                }
                catch (Exception ex)
                {
                    // Info sul tipo di errore
                    Console.WriteLine("Query.Select(): " + ex.Message);
                    // Operazione fallita
                    return false;
                }
            }
        }

        /// <summary>
        /// Riempie una DataGridView con i dati contenuti in una tabella (contenente una termine nella descrizione) del database
        /// </summary>
        /// <param name="table">Il nome della tabella all'interno del Database</param>
        /// <param name="term">Il termine da cercare all'interno della tabella</param>
        /// <param name="dataGrid">La DataGridView che verrà riempita</param>
        /// <returns>Ritorna true se l'operazione si è conclusa con successo, false altrimenti</returns>
        public static Boolean Select(String table, String term, DataGridView dataGrid)
        {
            // Se la tabella è quella principale
            if (table == "InventarioHW")
            {
                try
                {
                    // Resetto la griglia
                    dataGrid.DataSource = null;
                    // Dichiaro DataSet
                    DataSet dataSet = new DataSet();
                    // Dichiaro OleDbConnection al file del database
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Dichiaro OleDbAdapter
                    OleDbDataAdapter adapter = new OleDbDataAdapter("SELECT InventarioHW.id_inventarioHW, InventarioHW.valore, Tipologia.valore, OS.valore, InventarioHW.framework, CPU.valore, GPU.valore, InventarioHW.ram, InventarioHW.hd, InventarioHW.dataInserimento, InventarioHW.dataAcquisto, Locazione.valore, InventarioHW.utente, InventarioHW.ip FROM((((InventarioHW LEFT JOIN Tipologia ON InventarioHW.id_tipologia = Tipologia.id_tipologia) LEFT JOIN Locazione ON InventarioHW.id_locazione = Locazione.id_locazione) LEFT JOIN OS ON InventarioHW.id_OS = OS.id_OS) LEFT JOIN CPU ON InventarioHW.id_CPU = CPU.id_CPU) LEFT JOIN GPU ON InventarioHW.id_GPU = GPU.id_GPU WHERE InventarioHW.valore LIKE '%" + term + "%'", connection);
                    // Apro la connessione
                    connection.Open();
                    // Prendo i dati
                    adapter.Fill(dataSet);
                    // Chiudo la connessione
                    connection.Close();
                    // Copio i dati nella DataGridView prendoli dalla prima tabella
                    dataGrid.DataSource = dataSet.Tables[0];
                    // Aggiorno la grafica della griglia
                    dataGrid.Refresh();

                    // Operazione conclusa con successo
                    return true;
                }
                catch (Exception ex)
                {
                    // Info sul tipo di errore
                    Console.WriteLine("Query.Select(): " + ex.Message);
                    // Operazione fallita
                    return false;
                }
            }
            // Se è una delle altre tabelle
            else
            {
                try
                {
                    // Resetto la griglia
                    dataGrid.DataSource = null;
                    // Dichiaro DataSet
                    DataSet dataSet = new DataSet();
                    // Dichiaro OleDbConnection al file del database
                    OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
                    // Dichiaro OleDbAdapter
                    OleDbDataAdapter adapter = new OleDbDataAdapter("SELECT * FROM " + table + "WHERE valore LIKE '%" + term + "%';", connection);
                    // Apro la connessione
                    connection.Open();
                    // Prendo i dati
                    adapter.Fill(dataSet);
                    // Chiudo la connessione
                    connection.Close();
                    // Copio i dati nella DataGridView prendoli dalla prima tabella
                    dataGrid.DataSource = dataSet.Tables[0];
                    // Aggiorno la grafica della griglia
                    dataGrid.Refresh();

                    // Operazione conclusa con successo
                    return true;
                }
                catch (Exception ex)
                {
                    // Info sul tipo di errore
                    Console.WriteLine("Query.Select(): " + ex.Message);
                    // Operazione fallita
                    return false;
                }
            }
        }

        /// <summary>
        /// Verifica l'esistenza di una tabella nel database
        /// </summary>
        /// <param name="table">Il nome della tabella da verificare</param>
        /// <returns>Ritorna true se la tabella esiste, false altrimenti</returns>
        public static Boolean checkTable(String table)
        {
            // Dichiaro una OleDbConnection con il database
            OleDbConnection connection = new OleDbConnection(CONNECTION_STRING);
            // Apro la connessione
            connection.Open();
            // Prendo lo schema delle tabelle
            var schema = connection.GetOleDbSchemaTable(OleDbSchemaGuid.Tables, new object[] { null, null, null, "TABLE" });
            // Chiudo la connessione
            connection.Close();
            // Se la tabella esiste
            if (schema.Rows.OfType<DataRow>().Any(r => r.ItemArray[2].ToString().ToLower() == table.ToLower()))
            {
                // La tabella esiste
                return true;
            }
            else
            {
                // La tabella non esiste
                return false;
            }
        }
    }
}
