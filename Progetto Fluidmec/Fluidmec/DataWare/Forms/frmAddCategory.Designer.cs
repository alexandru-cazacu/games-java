namespace DataWare
{
    partial class frmAddCategory
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmAddCategory));
            this.txtValore = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.btnAggiungi = new System.Windows.Forms.Button();
            this.btnFine = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtValore
            // 
            this.txtValore.Location = new System.Drawing.Point(55, 6);
            this.txtValore.Name = "txtValore";
            this.txtValore.Size = new System.Drawing.Size(217, 20);
            this.txtValore.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "Valore";
            // 
            // btnAggiungi
            // 
            this.btnAggiungi.Location = new System.Drawing.Point(116, 87);
            this.btnAggiungi.Name = "btnAggiungi";
            this.btnAggiungi.Size = new System.Drawing.Size(75, 23);
            this.btnAggiungi.TabIndex = 2;
            this.btnAggiungi.Text = "Aggiungi";
            this.btnAggiungi.UseVisualStyleBackColor = true;
            this.btnAggiungi.Click += new System.EventHandler(this.btnAggiungi_Click);
            // 
            // btnFine
            // 
            this.btnFine.Location = new System.Drawing.Point(197, 87);
            this.btnFine.Name = "btnFine";
            this.btnFine.Size = new System.Drawing.Size(75, 23);
            this.btnFine.TabIndex = 3;
            this.btnFine.Text = "Fine";
            this.btnFine.UseVisualStyleBackColor = true;
            this.btnFine.Click += new System.EventHandler(this.btnFine_Click);
            // 
            // frmAddCategory
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 122);
            this.Controls.Add(this.btnFine);
            this.Controls.Add(this.btnAggiungi);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtValore);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "frmAddCategory";
            this.Text = "Aggiungi";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtValore;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnAggiungi;
        private System.Windows.Forms.Button btnFine;
    }
}