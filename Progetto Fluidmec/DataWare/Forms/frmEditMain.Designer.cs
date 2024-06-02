namespace DataWare.Forms
{
    partial class frmEditMain
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmEditMain));
            this.lblIP = new System.Windows.Forms.Label();
            this.lblUtente = new System.Windows.Forms.Label();
            this.txtIP = new System.Windows.Forms.TextBox();
            this.txtUtente = new System.Windows.Forms.TextBox();
            this.lblGPU = new System.Windows.Forms.Label();
            this.lblCPU = new System.Windows.Forms.Label();
            this.cmbGPU = new System.Windows.Forms.ComboBox();
            this.cmbCPU = new System.Windows.Forms.ComboBox();
            this.lblFramework = new System.Windows.Forms.Label();
            this.txtFramework = new System.Windows.Forms.TextBox();
            this.btnClose = new System.Windows.Forms.Button();
            this.btnAggiungi = new System.Windows.Forms.Button();
            this.lblLocazione = new System.Windows.Forms.Label();
            this.cmbLocazione = new System.Windows.Forms.ComboBox();
            this.lblDataAcquisto = new System.Windows.Forms.Label();
            this.lblDataInserimento = new System.Windows.Forms.Label();
            this.dateDataAcquisto = new System.Windows.Forms.DateTimePicker();
            this.dateDataInserimento = new System.Windows.Forms.DateTimePicker();
            this.lblHD = new System.Windows.Forms.Label();
            this.lblRAM = new System.Windows.Forms.Label();
            this.lblOS = new System.Windows.Forms.Label();
            this.lblTipologia = new System.Windows.Forms.Label();
            this.txtHD = new System.Windows.Forms.TextBox();
            this.txtRAM = new System.Windows.Forms.TextBox();
            this.cmbOS = new System.Windows.Forms.ComboBox();
            this.cmbTipologia = new System.Windows.Forms.ComboBox();
            this.txtDescrizione = new System.Windows.Forms.TextBox();
            this.lblDescrizione = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lblIP
            // 
            this.lblIP.AutoSize = true;
            this.lblIP.Location = new System.Drawing.Point(12, 329);
            this.lblIP.Name = "lblIP";
            this.lblIP.Size = new System.Drawing.Size(17, 13);
            this.lblIP.TabIndex = 126;
            this.lblIP.Text = "IP";
            // 
            // lblUtente
            // 
            this.lblUtente.AutoSize = true;
            this.lblUtente.Location = new System.Drawing.Point(12, 303);
            this.lblUtente.Name = "lblUtente";
            this.lblUtente.Size = new System.Drawing.Size(39, 13);
            this.lblUtente.TabIndex = 125;
            this.lblUtente.Text = "Utente";
            // 
            // txtIP
            // 
            this.txtIP.Location = new System.Drawing.Point(133, 326);
            this.txtIP.Name = "txtIP";
            this.txtIP.Size = new System.Drawing.Size(140, 20);
            this.txtIP.TabIndex = 124;
            // 
            // txtUtente
            // 
            this.txtUtente.Location = new System.Drawing.Point(133, 300);
            this.txtUtente.Name = "txtUtente";
            this.txtUtente.Size = new System.Drawing.Size(140, 20);
            this.txtUtente.TabIndex = 123;
            // 
            // lblGPU
            // 
            this.lblGPU.AutoSize = true;
            this.lblGPU.Location = new System.Drawing.Point(12, 145);
            this.lblGPU.Name = "lblGPU";
            this.lblGPU.Size = new System.Drawing.Size(30, 13);
            this.lblGPU.TabIndex = 122;
            this.lblGPU.Text = "GPU";
            // 
            // lblCPU
            // 
            this.lblCPU.AutoSize = true;
            this.lblCPU.Location = new System.Drawing.Point(12, 118);
            this.lblCPU.Name = "lblCPU";
            this.lblCPU.Size = new System.Drawing.Size(29, 13);
            this.lblCPU.TabIndex = 121;
            this.lblCPU.Text = "CPU";
            // 
            // cmbGPU
            // 
            this.cmbGPU.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbGPU.FormattingEnabled = true;
            this.cmbGPU.Location = new System.Drawing.Point(133, 142);
            this.cmbGPU.Name = "cmbGPU";
            this.cmbGPU.Size = new System.Drawing.Size(140, 21);
            this.cmbGPU.TabIndex = 120;
            // 
            // cmbCPU
            // 
            this.cmbCPU.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbCPU.FormattingEnabled = true;
            this.cmbCPU.Location = new System.Drawing.Point(133, 115);
            this.cmbCPU.Name = "cmbCPU";
            this.cmbCPU.Size = new System.Drawing.Size(140, 21);
            this.cmbCPU.TabIndex = 119;
            // 
            // lblFramework
            // 
            this.lblFramework.AutoSize = true;
            this.lblFramework.Location = new System.Drawing.Point(12, 92);
            this.lblFramework.Name = "lblFramework";
            this.lblFramework.Size = new System.Drawing.Size(103, 13);
            this.lblFramework.TabIndex = 118;
            this.lblFramework.Text = "Versione Framework";
            // 
            // txtFramework
            // 
            this.txtFramework.Location = new System.Drawing.Point(133, 89);
            this.txtFramework.Name = "txtFramework";
            this.txtFramework.Size = new System.Drawing.Size(140, 20);
            this.txtFramework.TabIndex = 117;
            // 
            // btnClose
            // 
            this.btnClose.Location = new System.Drawing.Point(249, 397);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(75, 23);
            this.btnClose.TabIndex = 116;
            this.btnClose.Text = "Fine";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // btnAggiungi
            // 
            this.btnAggiungi.Location = new System.Drawing.Point(168, 397);
            this.btnAggiungi.Name = "btnAggiungi";
            this.btnAggiungi.Size = new System.Drawing.Size(75, 23);
            this.btnAggiungi.TabIndex = 115;
            this.btnAggiungi.Text = "Modifica";
            this.btnAggiungi.UseVisualStyleBackColor = true;
            this.btnAggiungi.Click += new System.EventHandler(this.btnEdit_Click);
            // 
            // lblLocazione
            // 
            this.lblLocazione.AutoSize = true;
            this.lblLocazione.Location = new System.Drawing.Point(12, 276);
            this.lblLocazione.Name = "lblLocazione";
            this.lblLocazione.Size = new System.Drawing.Size(56, 13);
            this.lblLocazione.TabIndex = 114;
            this.lblLocazione.Text = "Locazione";
            // 
            // cmbLocazione
            // 
            this.cmbLocazione.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbLocazione.FormattingEnabled = true;
            this.cmbLocazione.Location = new System.Drawing.Point(133, 273);
            this.cmbLocazione.Name = "cmbLocazione";
            this.cmbLocazione.Size = new System.Drawing.Size(140, 21);
            this.cmbLocazione.TabIndex = 113;
            // 
            // lblDataAcquisto
            // 
            this.lblDataAcquisto.AutoSize = true;
            this.lblDataAcquisto.Location = new System.Drawing.Point(12, 253);
            this.lblDataAcquisto.Name = "lblDataAcquisto";
            this.lblDataAcquisto.Size = new System.Drawing.Size(74, 13);
            this.lblDataAcquisto.TabIndex = 112;
            this.lblDataAcquisto.Text = "Data Acquisto";
            // 
            // lblDataInserimento
            // 
            this.lblDataInserimento.AutoSize = true;
            this.lblDataInserimento.Location = new System.Drawing.Point(12, 227);
            this.lblDataInserimento.Name = "lblDataInserimento";
            this.lblDataInserimento.Size = new System.Drawing.Size(87, 13);
            this.lblDataInserimento.TabIndex = 111;
            this.lblDataInserimento.Text = "Data Inserimento";
            // 
            // dateDataAcquisto
            // 
            this.dateDataAcquisto.Location = new System.Drawing.Point(133, 247);
            this.dateDataAcquisto.Name = "dateDataAcquisto";
            this.dateDataAcquisto.Size = new System.Drawing.Size(191, 20);
            this.dateDataAcquisto.TabIndex = 110;
            // 
            // dateDataInserimento
            // 
            this.dateDataInserimento.Location = new System.Drawing.Point(133, 221);
            this.dateDataInserimento.Name = "dateDataInserimento";
            this.dateDataInserimento.Size = new System.Drawing.Size(191, 20);
            this.dateDataInserimento.TabIndex = 109;
            // 
            // lblHD
            // 
            this.lblHD.AutoSize = true;
            this.lblHD.Location = new System.Drawing.Point(12, 198);
            this.lblHD.Name = "lblHD";
            this.lblHD.Size = new System.Drawing.Size(23, 13);
            this.lblHD.TabIndex = 108;
            this.lblHD.Text = "HD";
            // 
            // lblRAM
            // 
            this.lblRAM.AutoSize = true;
            this.lblRAM.Location = new System.Drawing.Point(12, 172);
            this.lblRAM.Name = "lblRAM";
            this.lblRAM.Size = new System.Drawing.Size(31, 13);
            this.lblRAM.TabIndex = 107;
            this.lblRAM.Text = "RAM";
            // 
            // lblOS
            // 
            this.lblOS.AutoSize = true;
            this.lblOS.Location = new System.Drawing.Point(12, 65);
            this.lblOS.Name = "lblOS";
            this.lblOS.Size = new System.Drawing.Size(22, 13);
            this.lblOS.TabIndex = 106;
            this.lblOS.Text = "OS";
            // 
            // lblTipologia
            // 
            this.lblTipologia.AutoSize = true;
            this.lblTipologia.Location = new System.Drawing.Point(12, 38);
            this.lblTipologia.Name = "lblTipologia";
            this.lblTipologia.Size = new System.Drawing.Size(50, 13);
            this.lblTipologia.TabIndex = 105;
            this.lblTipologia.Text = "Tipologia";
            // 
            // txtHD
            // 
            this.txtHD.Location = new System.Drawing.Point(133, 195);
            this.txtHD.Name = "txtHD";
            this.txtHD.Size = new System.Drawing.Size(140, 20);
            this.txtHD.TabIndex = 104;
            // 
            // txtRAM
            // 
            this.txtRAM.Location = new System.Drawing.Point(133, 169);
            this.txtRAM.Name = "txtRAM";
            this.txtRAM.Size = new System.Drawing.Size(140, 20);
            this.txtRAM.TabIndex = 103;
            // 
            // cmbOS
            // 
            this.cmbOS.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbOS.FormattingEnabled = true;
            this.cmbOS.Location = new System.Drawing.Point(133, 62);
            this.cmbOS.Name = "cmbOS";
            this.cmbOS.Size = new System.Drawing.Size(140, 21);
            this.cmbOS.TabIndex = 102;
            // 
            // cmbTipologia
            // 
            this.cmbTipologia.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbTipologia.FormattingEnabled = true;
            this.cmbTipologia.Location = new System.Drawing.Point(133, 35);
            this.cmbTipologia.Name = "cmbTipologia";
            this.cmbTipologia.Size = new System.Drawing.Size(140, 21);
            this.cmbTipologia.TabIndex = 101;
            // 
            // txtDescrizione
            // 
            this.txtDescrizione.Location = new System.Drawing.Point(133, 9);
            this.txtDescrizione.Name = "txtDescrizione";
            this.txtDescrizione.Size = new System.Drawing.Size(140, 20);
            this.txtDescrizione.TabIndex = 100;
            // 
            // lblDescrizione
            // 
            this.lblDescrizione.AutoSize = true;
            this.lblDescrizione.Location = new System.Drawing.Point(12, 9);
            this.lblDescrizione.Name = "lblDescrizione";
            this.lblDescrizione.Size = new System.Drawing.Size(62, 13);
            this.lblDescrizione.TabIndex = 99;
            this.lblDescrizione.Text = "Descrizione";
            // 
            // frmEditMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(336, 432);
            this.Controls.Add(this.lblIP);
            this.Controls.Add(this.lblUtente);
            this.Controls.Add(this.txtIP);
            this.Controls.Add(this.txtUtente);
            this.Controls.Add(this.lblGPU);
            this.Controls.Add(this.lblCPU);
            this.Controls.Add(this.cmbGPU);
            this.Controls.Add(this.cmbCPU);
            this.Controls.Add(this.lblFramework);
            this.Controls.Add(this.txtFramework);
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.btnAggiungi);
            this.Controls.Add(this.lblLocazione);
            this.Controls.Add(this.cmbLocazione);
            this.Controls.Add(this.lblDataAcquisto);
            this.Controls.Add(this.lblDataInserimento);
            this.Controls.Add(this.dateDataAcquisto);
            this.Controls.Add(this.dateDataInserimento);
            this.Controls.Add(this.lblHD);
            this.Controls.Add(this.lblRAM);
            this.Controls.Add(this.lblOS);
            this.Controls.Add(this.lblTipologia);
            this.Controls.Add(this.txtHD);
            this.Controls.Add(this.txtRAM);
            this.Controls.Add(this.cmbOS);
            this.Controls.Add(this.cmbTipologia);
            this.Controls.Add(this.txtDescrizione);
            this.Controls.Add(this.lblDescrizione);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "frmEditMain";
            this.Text = "Modifica";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblIP;
        private System.Windows.Forms.Label lblUtente;
        private System.Windows.Forms.TextBox txtIP;
        private System.Windows.Forms.TextBox txtUtente;
        private System.Windows.Forms.Label lblGPU;
        private System.Windows.Forms.Label lblCPU;
        private System.Windows.Forms.ComboBox cmbGPU;
        private System.Windows.Forms.ComboBox cmbCPU;
        private System.Windows.Forms.Label lblFramework;
        private System.Windows.Forms.TextBox txtFramework;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnAggiungi;
        private System.Windows.Forms.Label lblLocazione;
        private System.Windows.Forms.ComboBox cmbLocazione;
        private System.Windows.Forms.Label lblDataAcquisto;
        private System.Windows.Forms.Label lblDataInserimento;
        private System.Windows.Forms.DateTimePicker dateDataAcquisto;
        private System.Windows.Forms.DateTimePicker dateDataInserimento;
        private System.Windows.Forms.Label lblHD;
        private System.Windows.Forms.Label lblRAM;
        private System.Windows.Forms.Label lblOS;
        private System.Windows.Forms.Label lblTipologia;
        private System.Windows.Forms.TextBox txtHD;
        private System.Windows.Forms.TextBox txtRAM;
        private System.Windows.Forms.ComboBox cmbOS;
        private System.Windows.Forms.ComboBox cmbTipologia;
        private System.Windows.Forms.TextBox txtDescrizione;
        private System.Windows.Forms.Label lblDescrizione;
    }
}