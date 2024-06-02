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

namespace DataWare.Forms
{
    public partial class frmAddMain : Form
    {
        public class ComboboxItem
        {
            public string Text { get; set; }
            public int Value { get; set; }

            public override string ToString()
            {
                return Text;
            }
        }

        private List<ComboboxItem> itemList = new List<ComboboxItem>();
        private List<String> category = new List<String>();
        private ComboboxItem item = new ComboboxItem();

        public frmAddMain()
        {
            InitializeComponent();

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
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnAggiungi_Click(object sender, EventArgs e)
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

            // Aggiungo il record
            Query.Insert("InventarioHW", values);
        }
    }
}
