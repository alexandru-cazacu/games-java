using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DataWare.Forms
{
    public partial class frmSearch : Form
    {
        String table;
        DataGridView dgView = new DataGridView();

        public frmSearch(DataGridView dgView, String table)
        {
            InitializeComponent();
            this.dgView = dgView;
            this.table = table;
        }

        private void btnFine_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnCerca_Click(object sender, EventArgs e)
        {
            Query.Select(table, txtValore.Text, dgView);
        }
    }
}
