namespace DataWare.Forms
{
    partial class frmSearch
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
            this.btnFine = new System.Windows.Forms.Button();
            this.btnCerca = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.txtValore = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // btnFine
            // 
            this.btnFine.Location = new System.Drawing.Point(197, 90);
            this.btnFine.Name = "btnFine";
            this.btnFine.Size = new System.Drawing.Size(75, 23);
            this.btnFine.TabIndex = 11;
            this.btnFine.Text = "Fine";
            this.btnFine.UseVisualStyleBackColor = true;
            this.btnFine.Click += new System.EventHandler(this.btnFine_Click);
            // 
            // btnCerca
            // 
            this.btnCerca.Location = new System.Drawing.Point(116, 90);
            this.btnCerca.Name = "btnCerca";
            this.btnCerca.Size = new System.Drawing.Size(75, 23);
            this.btnCerca.TabIndex = 10;
            this.btnCerca.Text = "Cerca";
            this.btnCerca.UseVisualStyleBackColor = true;
            this.btnCerca.Click += new System.EventHandler(this.btnCerca_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 12);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 13);
            this.label1.TabIndex = 9;
            this.label1.Text = "Valore";
            // 
            // txtValore
            // 
            this.txtValore.Location = new System.Drawing.Point(55, 9);
            this.txtValore.Name = "txtValore";
            this.txtValore.Size = new System.Drawing.Size(217, 20);
            this.txtValore.TabIndex = 8;
            // 
            // frmSearch
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 122);
            this.Controls.Add(this.btnFine);
            this.Controls.Add(this.btnCerca);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtValore);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Name = "frmSearch";
            this.Text = "Cerca";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnFine;
        private System.Windows.Forms.Button btnCerca;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtValore;
    }
}