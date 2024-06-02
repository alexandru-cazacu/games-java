using System;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Windows.Forms;

namespace InventarioHW
{
    public partial class frmMain : Form
    {
        public int currentRow = -1;

        public frmMain()
        {
            InitializeComponent();
            initGridInventory();

        }

        // Riempie la gridInventory
        public void initGridInventory()
        {
            // Seleziona tutti i valori della tabella principale
            Query.Select(dataGrid, "InventarioHW");
        }

        // Menu in basso - Search
        private void btnSearch_Click(object sender, EventArgs e)
        {
            // TODO
            //new frmSub(this, -2).Show();
        }

        // Menu in basso - Add
        private void btnAdd_Click(object sender, EventArgs e)
        {
            if (treeView.SelectedNode.Text == "InventarioHW")
            {
                new frmSub(this, -1).Show();
            }
            else
            {

            }
        }

        // Menu in basso - Change
        private void btnChange_Click(object sender, EventArgs e)
        {
            // TODO
            // Se ho selezionato una riga valida
            //if (currentRow != -1)
            //{
            //    new frmSub(this, currentRow).Show();
            //}
        }

        // Menu in basso - Delete
        private void btnDelete_Click(object sender, EventArgs e)
        {
            // TODO
            //// Se ho selezionato una riga valida
            //if (currentRow != -1)
            //{
            //    // Se clicco si sul MessageBox
            //    if (MessageBox.Show("Eliminare elemento selezionato?", "Conferma", MessageBoxButtons.YesNo) == DialogResult.Yes)
            //    {
            //        // Se non ci sono problemi nell'eliminazione
            //        if (Query.Delete(treeView.SelectedNode.Text, (int)dataGrid.Rows[currentRow].Cells[0].Value))
            //        {
            //            // Seleziona nuovi dati per la griglia
            //            Query.Select(dataGrid, treeView.SelectedNode.Text);

            //            // Se la riga eliminata era l'ultima
            //            if (currentRow == dataGrid.RowCount)
            //            {
            //                // Torno indietro di uno
            //                currentRow--;
            //            }

            //            // Seleziono una nuova riga
            //            dataGrid.ClearSelection();
            //            dataGrid.Rows[currentRow].Selected = true;

            //        }
            //    }
            //}
        }

        // Aggiorna indice quando clicco
        private void dataGrid_CellMouseDown(object sender, DataGridViewCellMouseEventArgs e)
        {
            // Se clicco un bottone del mouse
            if (e.Button == MouseButtons.Right || e.Button == MouseButtons.Left)
            {
                // Se sono in una riga con indice positivo
                if (e.RowIndex >= 0 && e.ColumnIndex >= 0)
                {
                    // Imposta l'indice e aggiorna la selezione alla riga corrente
                    currentRow = e.RowIndex;
                    dataGrid.ClearSelection();
                    dataGrid.Rows[e.RowIndex].Selected = true;
                }
            }

            dataGrid.Rows[currentRow].Cells[3].Style.BackColor = Color.Green;
            dataGrid.Rows[currentRow].Cells[3].Style.ForeColor = Color.White;
        }

        // Aggiorna la DataGridView in base al nodo che ho cliccato
        private void treeView_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            // Seleziona solo la tabella del nodo corrente
            Query.Select(dataGrid, e.Node.Text);

            // Resetto l'indice della riga corrente
            currentRow = -1;
            // Resetto la selezione sulla griglia
            dataGrid.ClearSelection();

            // Per i nodi intermedi e di collegamento, verra restituito false
            // e scritto l'errore sulla console
            // QUesto perchè non tutti i nodi hanno una relativa tabella
        }
    }
}
