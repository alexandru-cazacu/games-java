using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static DataWare.Forms.frmAddMain;

namespace DataWare.Forms
{
    public partial class frmEditMain : Form
    {
        String table;
        int id;

        private List<ComboboxItem> itemList = new List<ComboboxItem>();
        private List<String> category = new List<String>();
        private ComboboxItem item = new ComboboxItem();

        public frmEditMain(String table, int row, DataGridView dgView)
        {
            InitializeComponent();
            this.table = table;
            this.id = (int)dgView.Rows[row].Cells[0].Value;

            try
            {
                OleDbConnection connection = new OleDbConnection(Query.CONNECTION_STRING);
                connection.Open();

                category.Add("Tipologia");
                category.Add("OS");
                category.Add("CPU");
                category.Add("GPU");
                category.Add("Locazione");

                // Scorro le ComboBox
                for (int j = 0; j < category.Count; j++)
                {
                    DataTable dataTable = new DataTable();
                    itemList = new List<ComboboxItem>();
                    item = new ComboboxItem();
                    OleDbDataAdapter adapter = new OleDbDataAdapter("SELECT * FROM " + category[j], connection);
                    adapter.Fill(dataTable);
                    item.Text = j.ToString();
                    item.Value = -1;
                    itemList.Add(item);
                    // Scorro le righe della relativa tabella
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
                            cmbOS.DataSource = itemList;
                            cmbOS.DisplayMember = "Text";
                            cmbOS.ValueMember = "Value";
                            break;
                        case 2:
                            cmbCPU.DataSource = itemList;
                            cmbCPU.DisplayMember = "Text";
                            cmbCPU.ValueMember = "Value";
                            break;
                        case 3:
                            cmbGPU.DataSource = itemList;
                            cmbGPU.DisplayMember = "Text";
                            cmbGPU.ValueMember = "Value";
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
                Console.WriteLine("rmAddMain(): " + ex.Message);
            }

            // Text descrizione
            txtDescrizione.Text = dgView.Rows[row].Cells[1].Value.ToString();
            // Combo Tipologia
            cmbTipologia.SelectedIndex = cmbTipologia.FindString(dgView.Rows[row].Cells[2].Value.ToString());
            // Combo OS
            cmbOS.SelectedIndex = cmbOS.FindString(dgView.Rows[row].Cells[3].Value.ToString());
            // Text framework
            txtFramework.Text = dgView.Rows[row].Cells[4].Value.ToString();
            // Combo CPU
            cmbCPU.SelectedIndex = cmbCPU.FindString(dgView.Rows[row].Cells[5].Value.ToString());
            // Combo GPU
            cmbGPU.SelectedIndex = cmbGPU.FindString(dgView.Rows[row].Cells[6].Value.ToString());
            // Text RAM
            txtRAM.Text = dgView.Rows[row].Cells[7].Value.ToString();
            //  Text HD
            txtHD.Text = dgView.Rows[row].Cells[8].Value.ToString();
            // Data Inserimento
            dateDataInserimento.Value = Convert.ToDateTime(dgView.Rows[row].Cells[9].Value);
            // Data Acquisto
            dateDataAcquisto.Value = Convert.ToDateTime(dgView.Rows[row].Cells[10].Value);
            // Combo Locazione
            cmbLocazione.SelectedIndex = cmbLocazione.FindString(dgView.Rows[row].Cells[11].Value.ToString());
            // txt Utente
            txtUtente.Text = dgView.Rows[row].Cells[12].Value.ToString();
            // txt IP
            txtIP.Text = dgView.Rows[row].Cells[13].Value.ToString();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            // Dichiaro l'array di strighe che conterrà i valori
            String[] values = new String[13];

            // Imposto i valori
            values[0] = txtDescrizione.Text;
            values[1] = cmbTipologia.SelectedValue.ToString();
            values[2] = cmbOS.SelectedValue.ToString();
            values[3] = txtFramework.Text;
            values[4] = cmbCPU.SelectedValue.ToString();
            values[5] = cmbGPU.SelectedValue.ToString();
            values[6] = txtRAM.Text;
            values[7] = txtHD.Text;
            values[8] = dateDataInserimento.Value.Day + "/" + dateDataInserimento.Value.Month + "/" + dateDataInserimento.Value.Year;
            values[9] = dateDataAcquisto.Value.Day + "/" + dateDataAcquisto.Value.Month + "/" + dateDataAcquisto.Value.Year;
            values[10] = cmbLocazione.SelectedValue.ToString();
            values[11] = txtUtente.Text;
            values[12] = txtIP.Text;

            // Modifico il record
            Query.Update("InventarioHW", id, values);
        }
    }
}
