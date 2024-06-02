
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.OleDb;
using System.Windows.Forms;

namespace InventarioHW
{
    public partial class frmSub : Form
    {
        private OleDbConnection connection = new OleDbConnection();
        private OleDbDataAdapter adapter = new OleDbDataAdapter();
        private OleDbCommand command = new OleDbCommand();
        private DataTable dataTable = new DataTable();
        private DataSet dataset = new DataSet();

        private string connectionString = "Provider=Microsoft.ACE.OLEDB.12.0; Data Source= C:\\Users\\s.ced\\Desktop\\InventarioHW.accdb";
        private string query = "";
        private int op;
        private List<ComboboxItem> itemList = new List<ComboboxItem>();
        private List<String> category = new List<String>();
        private ComboboxItem item = new ComboboxItem();

        private frmMain frmMain;

        public class ComboboxItem
        {
            public string Text { get; set; }
            public int Value { get; set; }

            public override string ToString()
            {
                return Text;
            }
        }

        // Costruttore
        public frmSub(frmMain frm, int operation)
        {
            InitializeComponent();
            frmMain = frm;
            op = operation;

            #region Inizializza gli elementi grafici in base al tipo di azione
            try
            {
                connection = new OleDbConnection(connectionString);
                connection.Open();

                category.Add("Tipologia");
                category.Add("Marca");
                category.Add("CPU");
                category.Add("OS");
                category.Add("Locazione");

                for (int j = 0; j < category.Count; j++)
                {
                    dataTable = new DataTable();
                    itemList = new List<ComboboxItem>();
                    item = new ComboboxItem();
                    adapter = new OleDbDataAdapter("SELECT * FROM " + category[j], connection);
                    adapter.Fill(dataTable);
                    item.Text = j.ToString();
                    item.Value = -1;
                    itemList.Add(item);
                    for (int i = 0; i < dataTable.Rows.Count; i++)
                    {
                        item = new ComboboxItem();
                        item.Text = dataTable.Rows[i][1].ToString();
                        item.Value = (int)dataTable.Rows[i][0];
                        itemList.Add(item);
                    }

                    switch (j)
                    {
                        case 0:
                            cmbTipologia.DataSource = itemList;
                            cmbTipologia.DisplayMember = "Text";
                            cmbTipologia.ValueMember = "Value";
                            break;
                        case 1:
                            cmbMarca.DataSource = itemList;
                            cmbMarca.DisplayMember = "Text";
                            cmbMarca.ValueMember = "Value";
                            break;
                        case 2:
                            cmbCPU.DataSource = itemList;
                            cmbCPU.DisplayMember = "Text";
                            cmbCPU.ValueMember = "Value";
                            break;
                        case 3:
                            cmbOS.DataSource = itemList;
                            cmbOS.DisplayMember = "Text";
                            cmbOS.ValueMember = "Value";
                            break;
                        case 4:
                            cmbLocazione.DataSource = itemList;
                            cmbLocazione.DisplayMember = "Text";
                            cmbLocazione.ValueMember = "Value";
                            break;
                        default:
                            break;
                    }
                }
                connection.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Errore nell'inizializzazione delle Combo in frmSub: " + ex.Message.ToString());
            }
            #endregion

            #region Inizializzo form in base al tipo di azione
            // Inizializza form per Search
            if (op == -2)
            {
                this.Text = "Cerca";
                btnOperation.Text = "Cerca";
                lblDataAcquisto.Hide();
                lblDataInserimento.Hide();
                dateDataAcquisto.Hide();
                dateDataInserimento.Hide();
            }

            // Inizializza form per Add
            else if (op == -1)
            {
                this.Text = "Aggiungi";
                btnOperation.Text = "Aggiungi";
            }

            // Inizializza form per Edit
            else
            {
                this.Text = "Modifica";
                btnOperation.Text = "Modifica";
                txtDescrizione.Text = frmMain.dataGrid.Rows[op].Cells[1].Value.ToString();

                // Combo Tipologia
                cmbTipologia.SelectedIndex = cmbTipologia.FindString(frmMain.dataGrid.Rows[op].Cells[2].Value.ToString());
                // Combo Marca
                cmbMarca.SelectedIndex = cmbMarca.FindString(frmMain.dataGrid.Rows[op].Cells[3].Value.ToString());
                // Combo CPU
                cmbCPU.SelectedIndex = cmbCPU.FindString(frmMain.dataGrid.Rows[op].Cells[4].Value.ToString());
                // Text RAM
                txtRAM.Text = frmMain.dataGrid.Rows[op].Cells[5].Value.ToString();
                //  Text HD
                txtHD.Text = frmMain.dataGrid.Rows[op].Cells[6].Value.ToString();
                // Combo OS
                cmbOS.SelectedIndex = cmbOS.FindString(frmMain.dataGrid.Rows[op].Cells[7].Value.ToString());
                // Combo Locazione
                cmbLocazione.SelectedIndex = cmbLocazione.FindString(frmMain.dataGrid.Rows[op].Cells[8].Value.ToString());
                // Data Inserimento
                dateDataInserimento.Value = Convert.ToDateTime(frmMain.dataGrid.Rows[op].Cells[10].Value);
                // Data Acquisto
                dateDataAcquisto.Value = Convert.ToDateTime(frmMain.dataGrid.Rows[op].Cells[11].Value);
            }
            #endregion
        }

        // Clicco sul bottone per chiudere
        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        // Clicco sul bottone per eseguire l'azione
        private void btnOperation_Click(object sender, EventArgs e)
        {
            #region Azione Search
            if (op == -2)
            {
                try
                {
                    dataset.Clear();
                    connection = new OleDbConnection(connectionString);
                    connection.Open();

                    //Query di default
                    query = "SELECT id_inventarioHW, InventarioHW.descrizione, Tipologia.descrizione, Marca.descrizione, CPU.descrizione, InventarioHW.ram, InventarioHW.hd, OS.descrizione, Locazione.descrizione, InventarioHW.dataInserimento, InventarioHW.dataAcquisto, InventarioHW.utente FROM((((InventarioHW INNER JOIN Locazione ON InventarioHW.id_locazione = Locazione.id_locazione) INNER JOIN Marca ON InventarioHW.id_marca = Marca.id_marca) LEFT JOIN OS ON InventarioHW.id_OS = OS.id_OS) INNER JOIN Tipologia ON InventarioHW.id_tipologia = Tipologia.id_tipologia) LEFT JOIN CPU ON InventarioHW.id_CPU = CPU.id_CPU";
                    string strwhere = "";

                    //Descrizione
                    if (txtDescrizione.Text != "")
                    {
                        if (strwhere == "")
                            strwhere = " WHERE InventarioHW.descrizione like '%" + txtDescrizione.Text + "%'";
                        else
                            strwhere += " and  InventarioHW.descrizione like '%" + txtDescrizione.Text + "%'";
                    }

                    //Tipologia             
                    if (cmbTipologia.SelectedValue.ToString() != "-1")
                    {
                        if (strwhere == "")
                            strwhere = " WHERE InventarioHW.id_tipologia = " + cmbTipologia.SelectedValue;
                        else
                            strwhere += " and  InventarioHW.id_tipologia = " + cmbTipologia.SelectedValue;
                    }

                    //Marca
                    if (cmbMarca.SelectedValue.ToString() != "-1")
                    {
                        if (strwhere == "")
                            strwhere = " WHERE InventarioHW.id_marca = " + cmbMarca.SelectedValue;
                        else
                            strwhere += " and  InventarioHW.id_marca = " + cmbMarca.SelectedValue;
                    }

                    //CPU
                    if (cmbCPU.SelectedValue.ToString() != "-1")
                    {
                        if (strwhere == "")
                            strwhere = " WHERE InventarioHW.id_CPU = " + cmbCPU.SelectedValue;
                        else
                            strwhere += " and  InventarioHW.id_CPU = " + cmbCPU.SelectedValue;
                    }

                    //RAM
                    if (txtRAM.Text != "")
                    {
                        if (strwhere == "")
                        {
                            strwhere = " WHERE InventarioHW.ram = '" + txtRAM.Text + "'";
                        }
                        else
                        {
                            strwhere += " and  InventarioHW.ram = '" + txtRAM.Text + "'";
                        }
                    }

                    //HD
                    if (txtHD.Text != "")
                    {
                        if (strwhere == "")
                        {
                            strwhere = " WHERE InventarioHW.hd = '" + txtHD.Text + "'";
                        }
                        else
                        {
                            strwhere += " and  InventarioHW.hd = '" + txtHD.Text + "'";
                        }
                    }

                    //OS
                    if (cmbOS.SelectedValue.ToString() != "-1")
                    {
                        if (strwhere == "")
                            strwhere = " WHERE InventarioHW.id_os = " + cmbOS.SelectedValue;
                        else
                            strwhere += " and  InventarioHW.id_os = " + cmbOS.SelectedValue;
                    }

                    //Locazione
                    if (cmbLocazione.SelectedValue.ToString() != "-1")
                    {
                        if (strwhere == "")
                            strwhere = " WHERE InventarioHW.id_locazione = " + cmbLocazione.SelectedValue;
                        else
                            strwhere += " and  InventarioHW.id_locazione = " + cmbLocazione.SelectedValue;
                    }

                    //Concateno la stringa
                    query += strwhere;

                    adapter = new OleDbDataAdapter(query, connection);
                    adapter.Fill(dataset);
                    frmMain.dataGrid.DataSource = dataset.Tables[0];
                    frmMain.dataGrid.Refresh();
                    connection.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Errore Frame Sub (Search): " + ex.Message.ToString());
                }
            }
            #endregion

            #region Azione Add
            else if (op == -1)
            {
                try
                {
                    connection = new OleDbConnection(connectionString);
                    connection.Open();
                    query = "INSERT INTO InventarioHW (id_inventarioHW, descrizione, id_tipologia, id_marca, id_CPU, ram, hd, id_OS, dataInserimento, dataAcquisto, id_locazione, utente) VALUES (?,?,?,?,?,?,?,?,?,?,?);";
                    command = new OleDbCommand(query, connection);
                    command.Parameters.AddWithValue("descrizione", txtDescrizione.Text);
                    command.Parameters.AddWithValue("id_tipologia", cmbTipologia.SelectedValue);
                    command.Parameters.AddWithValue("id_marca", cmbMarca.SelectedValue);
                    command.Parameters.AddWithValue("id_CPU", cmbCPU.SelectedValue);
                    command.Parameters.AddWithValue("ram", txtRAM.Text);
                    command.Parameters.AddWithValue("hd", txtHD.Text);
                    command.Parameters.AddWithValue("id_OS", cmbOS.SelectedValue);
                    command.Parameters.AddWithValue("dataInserimento", dateDataInserimento.Value.Year + "/" + dateDataInserimento.Value.Month + "/" + dateDataInserimento.Value.Day);
                    command.Parameters.AddWithValue("dataAcquisto", dateDataAcquisto.Value.Year + "/" + dateDataAcquisto.Value.Month + "/" + dateDataAcquisto.Value.Day);
                    command.Parameters.AddWithValue("id_locazione", cmbLocazione.SelectedValue);
                    command.Parameters.AddWithValue("utente", "Pinco Pallo");
                    command.ExecuteNonQuery();
                    connection.Close();

                    frmMain.initGridInventory();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Errore Form Sub (Add): " + ex.Message.ToString());
                }
            }
            #endregion

            #region Azione Edit
            else
            {
                try
                {
                    connection = new OleDbConnection(connectionString);
                    query = "UPDATE inventarioHW ";
                    query += "SET descrizione = '" + txtDescrizione.Text + "', ";
                    query += "id_tipologia = " + cmbTipologia.SelectedValue + ", ";
                    query += "id_marca = " + cmbMarca.SelectedValue + ", ";
                    query += "id_CPU = " + cmbCPU.SelectedValue + ", ";
                    query += "ram = '" + txtRAM.Text + "', ";
                    query += "hd = '" + txtHD.Text + "', ";
                    query += "id_OS = " + cmbOS.SelectedValue + ", ";
                    query += "dataInserimento = " + dateDataInserimento.Value.Year + "/" + dateDataInserimento.Value.Month + "/" + dateDataInserimento.Value.Day + ", ";
                    query += "dataAcquisto = " + dateDataAcquisto.Value.Year + "/" + dateDataAcquisto.Value.Month + "/" + dateDataAcquisto.Value.Day + ", ";
                    query += "id_locazione = " + cmbLocazione.SelectedValue + " ";
                    query += "WHERE id_inventarioHW = " + frmMain.dataGrid.Rows[op].Cells[0].Value.ToString() + ";";
                    command = new OleDbCommand(query, connection);
                    connection.Open();
                    command.ExecuteNonQuery();
                    connection.Close();
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Errore Form Sub (Edit): " + ex.Message.ToString());
                }

                frmMain.initGridInventory();

                // Seleziono la stessa riga
                frmMain.dataGrid.ClearSelection();
                frmMain.dataGrid.Rows[frmMain.currentRow].Selected = true;
            }
            #endregion
        }
    }
}