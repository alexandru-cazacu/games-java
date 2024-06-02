namespace InventarioHW
{
    partial class frmCategory
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
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.txtAdd = new System.Windows.Forms.Button();
            this.txtClose = new System.Windows.Forms.Button();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(13, 39);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(197, 20);
            this.textBox1.TabIndex = 0;
            // 
            // txtAdd
            // 
            this.txtAdd.Location = new System.Drawing.Point(13, 227);
            this.txtAdd.Name = "txtAdd";
            this.txtAdd.Size = new System.Drawing.Size(75, 23);
            this.txtAdd.TabIndex = 1;
            this.txtAdd.Text = "Aggiungi";
            this.txtAdd.UseVisualStyleBackColor = true;
            // 
            // txtClose
            // 
            this.txtClose.Location = new System.Drawing.Point(135, 227);
            this.txtClose.Name = "txtClose";
            this.txtClose.Size = new System.Drawing.Size(75, 23);
            this.txtClose.TabIndex = 2;
            this.txtClose.Text = "Fine";
            this.txtClose.UseVisualStyleBackColor = true;
            // 
            // comboBox1
            // 
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Location = new System.Drawing.Point(12, 12);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(197, 21);
            this.comboBox1.TabIndex = 3;
            // 
            // frmCategory
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(222, 262);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.txtClose);
            this.Controls.Add(this.txtAdd);
            this.Controls.Add(this.textBox1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Name = "frmCategory";
            this.Text = "Aggiungi";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Button txtAdd;
        private System.Windows.Forms.Button txtClose;
        private System.Windows.Forms.ComboBox comboBox1;
    }
}