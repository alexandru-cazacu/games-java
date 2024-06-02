using DataWare.Forms;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DataWare
{
    public partial class frmMain : Form
    {
        private int currentRow = -1;
        private String currentTable = "null";

        public frmMain()
        {
            InitializeComponent();

            // Impost l'albero gerarchico delle tabelle
            treeViewDatabase.Nodes.Add("Database");
            treeViewDatabase.Nodes[0].Nodes.Add("InventarioHW");
            treeViewDatabase.Nodes[0].Nodes[0].Nodes.Add("Tipologia");
            treeViewDatabase.Nodes[0].Nodes[0].Nodes.Add("OS");
            treeViewDatabase.Nodes[0].Nodes[0].Nodes.Add("CPU");
            treeViewDatabase.Nodes[0].Nodes[0].Nodes.Add("GPU");
            treeViewDatabase.Nodes[0].Nodes[0].Nodes.Add("Locazione");
            treeViewDatabase.Show();
        }

        // Visualizza - nasconde la gerarchia
        private void stripMenu_btnVisualizza_btnGerarchia_Click(object sender, EventArgs e)
        {
            if (stripMenu_btnVisualizza_btnGerarchia.CheckState == CheckState.Checked)
            {
                stripMenu_btnVisualizza_btnGerarchia.CheckState = CheckState.Unchecked;
                tabControlRight.Location = new Point(4, 4);
                tabControlRight.Width += 203;
                tabControlLeft.Visible = false;
            }

            else
            {
                stripMenu_btnVisualizza_btnGerarchia.CheckState = CheckState.Checked;
                tabControlLeft.Visible = true;
                tabControlRight.Location = new Point(207, 4);
                tabControlRight.Width -= 203;
            }
        }

        // Visualizza - nasconde il databse
        private void stripMenu_btnVisualizza_btnDatabase_Click(object sender, EventArgs e)
        {
            if (stripMenu_btnVisualizza_btnDatabase.CheckState == CheckState.Checked)
            {
                stripMenu_btnVisualizza_btnDatabase.CheckState = CheckState.Unchecked;
                tabControlRight.Visible = false;
            }

            else
            {
                stripMenu_btnVisualizza_btnDatabase.CheckState = CheckState.Checked;
                tabControlRight.Visible = true;
            }
        }

        // Visualizza - nasconde la barra strumenti
        private void stripMenu_btnVisualizza_btnTools_Click(object sender, EventArgs e)
        {
            if (stripMenu_btnVisualizza_btnTools.CheckState == CheckState.Checked)
            {
                stripMenu_btnVisualizza_btnTools.CheckState = CheckState.Unchecked;
                stripTools.Visible = false;
            }

            else
            {
                stripMenu_btnVisualizza_btnTools.CheckState = CheckState.Checked;
                stripTools.Visible = true;
            }
        }

        // Visualizza - nasconde la barra info
        private void stripMenu_btnVisualizza_btnInfo_Click(object sender, EventArgs e)
        {
            if (stripMenu_btnVisualizza_btnInfo.CheckState == CheckState.Checked)
            {
                stripMenu_btnVisualizza_btnInfo.CheckState = CheckState.Unchecked;
                stripInfo.Visible = false;
            }

            else
            {
                stripMenu_btnVisualizza_btnInfo.CheckState = CheckState.Checked;
                stripInfo.Visible = true;
            }
        }

        // Imposta la riga corrente dopo che ho selezionato una cella
        private void dataGridViewDatabase_CellMouseDown(object sender, DataGridViewCellMouseEventArgs e)
        {
            // Se clicco un bottone del mouse
            if (e.Button == MouseButtons.Right || e.Button == MouseButtons.Left)
            {
                // Se sono in una riga con indice positivo
                if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
                {
                    // Imposta l'indice e aggiorna la selezione alla riga corrente
                    currentRow = e.RowIndex;
                    stripInfo_lblInfo.Text = currentRow.ToString();
                    dataGridViewDatabase.ClearSelection();
                    dataGridViewDatabase.Rows[e.RowIndex].Selected = true;

                    stripInfo_lblInfo.Text = "Tabella: " + currentTable +" Riga: " + currentRow;
                }
            }
        }

        // Imposta la tabella corrente dopo che ho selezionato un nodo
        private void treeViewDatabase_AfterSelect(object sender, TreeViewEventArgs e)
        {
            currentTable = treeViewDatabase.SelectedNode.Text.ToString();
            currentRow = -1;
            Query.Select(currentTable, dataGridViewDatabase);
            dataGridViewDatabase.ClearSelection();

            stripInfo_lblInfo.Text = "Tabella: " + currentTable + " Riga: " + currentRow;
        }

        // Aggiorna la grafica della tabella corrente
        private void stripTools_btnRefresh_Click(object sender, EventArgs e)
        {
            // Se il nodo selezionato ha una relativa tabella nel databse
            if (Query.checkTable(currentTable))
            {
                // Seleziono la relativa tabella
                Query.Select(treeViewDatabase.SelectedNode.Text, dataGridViewDatabase);
                // Azzero la selezione
                dataGridViewDatabase.ClearSelection();
            }
        }

        // Visualizza il form della ricerca
        private void stripTools_btnSearch_Click(object sender, EventArgs e)
        {
            new frmSearch(dataGridViewDatabase, currentTable).Show();
        }

        // Visualizza il form per aggiungere una nuova categoria
        private void stripTools_btnAdd_Click(object sender, EventArgs e)
        {
            // Se il nodo selezionato ha una relativa tabella nel databse
            if (Query.checkTable(currentTable))
            {
                // Se il nodo è la tabella principale
                if (currentTable == "InventarioHW")
                {
                    new frmAddMain().Show();
                }
                // Se è una delle altre tabelle
                else
                {
                    new frmAddCategory(currentTable).Show();
                }
            }
        }

        // Visualizza il form per modificare la riga selezionata della tabella selezionata
        private void stripTools_btnEdit_Click(object sender, EventArgs e)
        {
            // Se il nodo selezionato ha una relativa tabella nel databse
            if (Query.checkTable(currentTable) && currentRow != -1)
            {
                // Se il nodo è la tabella principale
                if (currentTable == "InventarioHW")
                {
                    new frmEditMain("InventarioHW", currentRow, dataGridViewDatabase).Show();
                }
                // Se è una delle altre tabelle
                else
                {
                    new frmEditCategory(currentTable, (int)dataGridViewDatabase.Rows[currentRow].Cells[0].Value, dataGridViewDatabase.Rows[currentRow].Cells[1].Value.ToString()).Show();
                }
            }
        }

        // Elimina la riga selezionata della tabella selezionata
        private void stripTools_btnDelete_Click(object sender, EventArgs e)
        {
            // Se ho selezionato una riga valida
            if (currentRow != -1)
            {
                // Se clicco si sul MessageBox
                if (MessageBox.Show("Eliminare elemento selezionato?", "Conferma", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    // Se non ci sono problemi nell'eliminazione
                    if (Query.Delete(currentTable, (int)dataGridViewDatabase.Rows[currentRow].Cells[0].Value))
                    {
                        // Seleziona nuovi dati per la griglia
                        Query.Select(currentTable, dataGridViewDatabase);

                        // Se la riga eliminata era l'ultima
                        if (currentRow == dataGridViewDatabase.RowCount)
                        {
                            // Torno indietro di uno
                            currentRow--;
                        }

                        // Seleziono una nuova riga
                        dataGridViewDatabase.ClearSelection();
                        dataGridViewDatabase.Rows[currentRow].Selected = true;
                    }
                }
            }
        }
    }
}
