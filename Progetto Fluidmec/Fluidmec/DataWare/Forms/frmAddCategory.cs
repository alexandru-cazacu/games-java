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
    public partial class frmAddCategory : Form
    {
        private String table = "";

        public frmAddCategory(String subTable)
        {
            InitializeComponent();
            this.table = subTable;
        }

        private void btnFine_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnAggiungi_Click(object sender, EventArgs e)
        {
            Query.Insert(table, new String[] { txtValore.Text });
        }
    }
}
