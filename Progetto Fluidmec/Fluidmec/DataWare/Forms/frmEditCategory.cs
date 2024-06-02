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
    public partial class frmEditCategory : Form
    {
        private String table;
        private int id;
        private String value;

        public frmEditCategory(String table, int id, String value)
        {
            InitializeComponent();
            this.table = table;
            this.id = id;
            this.value = value;

            txtValore.Text = value;
        }

        private void btnFine_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnModifica_Click(object sender, EventArgs e)
        {
            Query.Update(table, id, new String[] { txtValore.Text });
        }
    }
}
