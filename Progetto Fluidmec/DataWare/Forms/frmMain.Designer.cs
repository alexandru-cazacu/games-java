namespace DataWare
{
    partial class frmMain
    {
        /// <summary>
        /// Variabile di progettazione necessaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Pulire le risorse in uso.
        /// </summary>
        /// <param name="disposing">ha valore true se le risorse gestite devono essere eliminate, false in caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Codice generato da Progettazione Windows Form

        /// <summary>
        /// Metodo necessario per il supporto della finestra di progettazione. Non modificare
        /// il contenuto del metodo con l'editor di codice.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmMain));
            this.toolStripContainer = new System.Windows.Forms.ToolStripContainer();
            this.stripInfo = new System.Windows.Forms.StatusStrip();
            this.stripInfo_lblInfo = new System.Windows.Forms.ToolStripStatusLabel();
            this.tabControlRight = new System.Windows.Forms.TabControl();
            this.tabPageRight = new System.Windows.Forms.TabPage();
            this.dataGridViewDatabase = new System.Windows.Forms.DataGridView();
            this.tabControlLeft = new System.Windows.Forms.TabControl();
            this.tabPageLeft = new System.Windows.Forms.TabPage();
            this.treeViewDatabase = new System.Windows.Forms.TreeView();
            this.stripMenu = new System.Windows.Forms.MenuStrip();
            this.stripMenu_btnFile = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnFile_btnNuovo = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnFile_btnApri = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator = new System.Windows.Forms.ToolStripSeparator();
            this.stripMenu_btnFile_btnSalva = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnFile_btnSalva2 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator1 = new System.Windows.Forms.ToolStripSeparator();
            this.stripMenu_btnFile_btnStampa = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnFile_btnStampa2 = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator2 = new System.Windows.Forms.ToolStripSeparator();
            this.stripMenu_btnFile_btnEsci = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnModifica = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnModifica_btnAnnulla = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnModifica_btnRipristina = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator3 = new System.Windows.Forms.ToolStripSeparator();
            this.stripMenu_btnModifica_btnTaglia = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnModifica_btnCopia = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnModifica_btnIncolla = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator4 = new System.Windows.Forms.ToolStripSeparator();
            this.stripMenu_btnModifica_btnSelezionaTutto = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnVisualizza = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnVisualizza_btnGerarchia = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnVisualizza_btnDatabase = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnVisualizza_btnTools = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnVisualizza_btnInfo = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnStrumenti = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnStrumenti_btnPersonalizza = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnStrumenti_btnOpzioni = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnInfo = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnInfo_btnSommario = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnInfo_btnIndice = new System.Windows.Forms.ToolStripMenuItem();
            this.stripMenu_btnInfo_btnCerca = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripSeparator5 = new System.Windows.Forms.ToolStripSeparator();
            this.stripMenu_btnInfo_btnInfo = new System.Windows.Forms.ToolStripMenuItem();
            this.stripTools = new System.Windows.Forms.ToolStrip();
            this.stripTools_btnEdit = new System.Windows.Forms.ToolStripButton();
            this.stripTools_btnDelete = new System.Windows.Forms.ToolStripButton();
            this.toolStripSeparator6 = new System.Windows.Forms.ToolStripSeparator();
            this.stripTools_btnAdd = new System.Windows.Forms.ToolStripButton();
            this.stripTools_btnRefresh = new System.Windows.Forms.ToolStripButton();
            this.stripTools_btnSearch = new System.Windows.Forms.ToolStripButton();
            this.toolStripContainer.BottomToolStripPanel.SuspendLayout();
            this.toolStripContainer.ContentPanel.SuspendLayout();
            this.toolStripContainer.TopToolStripPanel.SuspendLayout();
            this.toolStripContainer.SuspendLayout();
            this.stripInfo.SuspendLayout();
            this.tabControlRight.SuspendLayout();
            this.tabPageRight.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewDatabase)).BeginInit();
            this.tabControlLeft.SuspendLayout();
            this.tabPageLeft.SuspendLayout();
            this.stripMenu.SuspendLayout();
            this.stripTools.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolStripContainer
            // 
            // 
            // toolStripContainer.BottomToolStripPanel
            // 
            this.toolStripContainer.BottomToolStripPanel.Controls.Add(this.stripInfo);
            // 
            // toolStripContainer.ContentPanel
            // 
            this.toolStripContainer.ContentPanel.Controls.Add(this.tabControlRight);
            this.toolStripContainer.ContentPanel.Controls.Add(this.tabControlLeft);
            this.toolStripContainer.ContentPanel.Size = new System.Drawing.Size(1072, 544);
            this.toolStripContainer.Dock = System.Windows.Forms.DockStyle.Fill;
            this.toolStripContainer.Location = new System.Drawing.Point(0, 0);
            this.toolStripContainer.Name = "toolStripContainer";
            this.toolStripContainer.Size = new System.Drawing.Size(1072, 615);
            this.toolStripContainer.TabIndex = 0;
            this.toolStripContainer.Text = "toolStripContainer1";
            // 
            // toolStripContainer.TopToolStripPanel
            // 
            this.toolStripContainer.TopToolStripPanel.Controls.Add(this.stripMenu);
            this.toolStripContainer.TopToolStripPanel.Controls.Add(this.stripTools);
            // 
            // stripInfo
            // 
            this.stripInfo.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Bottom | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.stripInfo.Dock = System.Windows.Forms.DockStyle.None;
            this.stripInfo.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stripInfo_lblInfo});
            this.stripInfo.Location = new System.Drawing.Point(0, 0);
            this.stripInfo.Name = "stripInfo";
            this.stripInfo.Size = new System.Drawing.Size(1072, 22);
            this.stripInfo.TabIndex = 0;
            // 
            // stripInfo_lblInfo
            // 
            this.stripInfo_lblInfo.Name = "stripInfo_lblInfo";
            this.stripInfo_lblInfo.Size = new System.Drawing.Size(34, 17);
            this.stripInfo_lblInfo.Text = "Info: ";
            // 
            // tabControlRight
            // 
            this.tabControlRight.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.tabControlRight.Controls.Add(this.tabPageRight);
            this.tabControlRight.Location = new System.Drawing.Point(207, 4);
            this.tabControlRight.Name = "tabControlRight";
            this.tabControlRight.SelectedIndex = 0;
            this.tabControlRight.Size = new System.Drawing.Size(862, 537);
            this.tabControlRight.TabIndex = 1;
            // 
            // tabPageRight
            // 
            this.tabPageRight.Controls.Add(this.dataGridViewDatabase);
            this.tabPageRight.Location = new System.Drawing.Point(4, 22);
            this.tabPageRight.Name = "tabPageRight";
            this.tabPageRight.Padding = new System.Windows.Forms.Padding(3);
            this.tabPageRight.Size = new System.Drawing.Size(854, 511);
            this.tabPageRight.TabIndex = 0;
            this.tabPageRight.Text = "Database";
            this.tabPageRight.UseVisualStyleBackColor = true;
            // 
            // dataGridViewDatabase
            // 
            this.dataGridViewDatabase.AllowUserToAddRows = false;
            this.dataGridViewDatabase.AllowUserToDeleteRows = false;
            this.dataGridViewDatabase.AllowUserToResizeRows = false;
            this.dataGridViewDatabase.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.dataGridViewDatabase.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataGridViewDatabase.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridViewDatabase.Location = new System.Drawing.Point(3, 3);
            this.dataGridViewDatabase.MultiSelect = false;
            this.dataGridViewDatabase.Name = "dataGridViewDatabase";
            this.dataGridViewDatabase.ReadOnly = true;
            this.dataGridViewDatabase.RowHeadersVisible = false;
            this.dataGridViewDatabase.RowHeadersWidthSizeMode = System.Windows.Forms.DataGridViewRowHeadersWidthSizeMode.AutoSizeToAllHeaders;
            this.dataGridViewDatabase.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dataGridViewDatabase.ShowCellErrors = false;
            this.dataGridViewDatabase.ShowCellToolTips = false;
            this.dataGridViewDatabase.ShowEditingIcon = false;
            this.dataGridViewDatabase.ShowRowErrors = false;
            this.dataGridViewDatabase.Size = new System.Drawing.Size(848, 505);
            this.dataGridViewDatabase.TabIndex = 0;
            this.dataGridViewDatabase.TabStop = false;
            this.dataGridViewDatabase.CellMouseDown += new System.Windows.Forms.DataGridViewCellMouseEventHandler(this.dataGridViewDatabase_CellMouseDown);
            // 
            // tabControlLeft
            // 
            this.tabControlLeft.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom) 
            | System.Windows.Forms.AnchorStyles.Left)));
            this.tabControlLeft.Controls.Add(this.tabPageLeft);
            this.tabControlLeft.Location = new System.Drawing.Point(4, 4);
            this.tabControlLeft.Name = "tabControlLeft";
            this.tabControlLeft.SelectedIndex = 0;
            this.tabControlLeft.Size = new System.Drawing.Size(200, 537);
            this.tabControlLeft.TabIndex = 0;
            // 
            // tabPageLeft
            // 
            this.tabPageLeft.Controls.Add(this.treeViewDatabase);
            this.tabPageLeft.Location = new System.Drawing.Point(4, 22);
            this.tabPageLeft.Name = "tabPageLeft";
            this.tabPageLeft.Padding = new System.Windows.Forms.Padding(3);
            this.tabPageLeft.Size = new System.Drawing.Size(192, 511);
            this.tabPageLeft.TabIndex = 0;
            this.tabPageLeft.Text = "Gerarchia";
            this.tabPageLeft.UseVisualStyleBackColor = true;
            // 
            // treeViewDatabase
            // 
            this.treeViewDatabase.Dock = System.Windows.Forms.DockStyle.Fill;
            this.treeViewDatabase.Location = new System.Drawing.Point(3, 3);
            this.treeViewDatabase.Name = "treeViewDatabase";
            this.treeViewDatabase.Size = new System.Drawing.Size(186, 505);
            this.treeViewDatabase.TabIndex = 0;
            this.treeViewDatabase.AfterSelect += new System.Windows.Forms.TreeViewEventHandler(this.treeViewDatabase_AfterSelect);
            // 
            // stripMenu
            // 
            this.stripMenu.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.stripMenu.Dock = System.Windows.Forms.DockStyle.None;
            this.stripMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stripMenu_btnFile,
            this.stripMenu_btnModifica,
            this.stripMenu_btnVisualizza,
            this.stripMenu_btnStrumenti,
            this.stripMenu_btnInfo});
            this.stripMenu.Location = new System.Drawing.Point(0, 0);
            this.stripMenu.Name = "stripMenu";
            this.stripMenu.Size = new System.Drawing.Size(1072, 24);
            this.stripMenu.TabIndex = 0;
            // 
            // stripMenu_btnFile
            // 
            this.stripMenu_btnFile.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stripMenu_btnFile_btnNuovo,
            this.stripMenu_btnFile_btnApri,
            this.toolStripSeparator,
            this.stripMenu_btnFile_btnSalva,
            this.stripMenu_btnFile_btnSalva2,
            this.toolStripSeparator1,
            this.stripMenu_btnFile_btnStampa,
            this.stripMenu_btnFile_btnStampa2,
            this.toolStripSeparator2,
            this.stripMenu_btnFile_btnEsci});
            this.stripMenu_btnFile.Name = "stripMenu_btnFile";
            this.stripMenu_btnFile.Size = new System.Drawing.Size(37, 20);
            this.stripMenu_btnFile.Text = "&File";
            // 
            // stripMenu_btnFile_btnNuovo
            // 
            this.stripMenu_btnFile_btnNuovo.Image = ((System.Drawing.Image)(resources.GetObject("stripMenu_btnFile_btnNuovo.Image")));
            this.stripMenu_btnFile_btnNuovo.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripMenu_btnFile_btnNuovo.Name = "stripMenu_btnFile_btnNuovo";
            this.stripMenu_btnFile_btnNuovo.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.N)));
            this.stripMenu_btnFile_btnNuovo.Size = new System.Drawing.Size(185, 22);
            this.stripMenu_btnFile_btnNuovo.Text = "&Nuovo";
            // 
            // stripMenu_btnFile_btnApri
            // 
            this.stripMenu_btnFile_btnApri.Image = ((System.Drawing.Image)(resources.GetObject("stripMenu_btnFile_btnApri.Image")));
            this.stripMenu_btnFile_btnApri.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripMenu_btnFile_btnApri.Name = "stripMenu_btnFile_btnApri";
            this.stripMenu_btnFile_btnApri.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.O)));
            this.stripMenu_btnFile_btnApri.Size = new System.Drawing.Size(185, 22);
            this.stripMenu_btnFile_btnApri.Text = "&Apri";
            // 
            // toolStripSeparator
            // 
            this.toolStripSeparator.Name = "toolStripSeparator";
            this.toolStripSeparator.Size = new System.Drawing.Size(182, 6);
            // 
            // stripMenu_btnFile_btnSalva
            // 
            this.stripMenu_btnFile_btnSalva.Image = ((System.Drawing.Image)(resources.GetObject("stripMenu_btnFile_btnSalva.Image")));
            this.stripMenu_btnFile_btnSalva.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripMenu_btnFile_btnSalva.Name = "stripMenu_btnFile_btnSalva";
            this.stripMenu_btnFile_btnSalva.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.S)));
            this.stripMenu_btnFile_btnSalva.Size = new System.Drawing.Size(185, 22);
            this.stripMenu_btnFile_btnSalva.Text = "&Salva";
            // 
            // stripMenu_btnFile_btnSalva2
            // 
            this.stripMenu_btnFile_btnSalva2.Name = "stripMenu_btnFile_btnSalva2";
            this.stripMenu_btnFile_btnSalva2.Size = new System.Drawing.Size(185, 22);
            this.stripMenu_btnFile_btnSalva2.Text = "Salva &con nome";
            // 
            // toolStripSeparator1
            // 
            this.toolStripSeparator1.Name = "toolStripSeparator1";
            this.toolStripSeparator1.Size = new System.Drawing.Size(182, 6);
            // 
            // stripMenu_btnFile_btnStampa
            // 
            this.stripMenu_btnFile_btnStampa.Image = ((System.Drawing.Image)(resources.GetObject("stripMenu_btnFile_btnStampa.Image")));
            this.stripMenu_btnFile_btnStampa.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripMenu_btnFile_btnStampa.Name = "stripMenu_btnFile_btnStampa";
            this.stripMenu_btnFile_btnStampa.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.P)));
            this.stripMenu_btnFile_btnStampa.Size = new System.Drawing.Size(185, 22);
            this.stripMenu_btnFile_btnStampa.Text = "&Stampa";
            // 
            // stripMenu_btnFile_btnStampa2
            // 
            this.stripMenu_btnFile_btnStampa2.Image = ((System.Drawing.Image)(resources.GetObject("stripMenu_btnFile_btnStampa2.Image")));
            this.stripMenu_btnFile_btnStampa2.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripMenu_btnFile_btnStampa2.Name = "stripMenu_btnFile_btnStampa2";
            this.stripMenu_btnFile_btnStampa2.Size = new System.Drawing.Size(185, 22);
            this.stripMenu_btnFile_btnStampa2.Text = "&Anteprima di stampa";
            // 
            // toolStripSeparator2
            // 
            this.toolStripSeparator2.Name = "toolStripSeparator2";
            this.toolStripSeparator2.Size = new System.Drawing.Size(182, 6);
            // 
            // stripMenu_btnFile_btnEsci
            // 
            this.stripMenu_btnFile_btnEsci.Name = "stripMenu_btnFile_btnEsci";
            this.stripMenu_btnFile_btnEsci.Size = new System.Drawing.Size(185, 22);
            this.stripMenu_btnFile_btnEsci.Text = "&Esci";
            // 
            // stripMenu_btnModifica
            // 
            this.stripMenu_btnModifica.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stripMenu_btnModifica_btnAnnulla,
            this.stripMenu_btnModifica_btnRipristina,
            this.toolStripSeparator3,
            this.stripMenu_btnModifica_btnTaglia,
            this.stripMenu_btnModifica_btnCopia,
            this.stripMenu_btnModifica_btnIncolla,
            this.toolStripSeparator4,
            this.stripMenu_btnModifica_btnSelezionaTutto});
            this.stripMenu_btnModifica.Name = "stripMenu_btnModifica";
            this.stripMenu_btnModifica.Size = new System.Drawing.Size(66, 20);
            this.stripMenu_btnModifica.Text = "&Modifica";
            // 
            // stripMenu_btnModifica_btnAnnulla
            // 
            this.stripMenu_btnModifica_btnAnnulla.Name = "stripMenu_btnModifica_btnAnnulla";
            this.stripMenu_btnModifica_btnAnnulla.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.Z)));
            this.stripMenu_btnModifica_btnAnnulla.Size = new System.Drawing.Size(173, 22);
            this.stripMenu_btnModifica_btnAnnulla.Text = "&Annulla";
            // 
            // stripMenu_btnModifica_btnRipristina
            // 
            this.stripMenu_btnModifica_btnRipristina.Name = "stripMenu_btnModifica_btnRipristina";
            this.stripMenu_btnModifica_btnRipristina.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.Y)));
            this.stripMenu_btnModifica_btnRipristina.Size = new System.Drawing.Size(173, 22);
            this.stripMenu_btnModifica_btnRipristina.Text = "&Ripristina";
            // 
            // toolStripSeparator3
            // 
            this.toolStripSeparator3.Name = "toolStripSeparator3";
            this.toolStripSeparator3.Size = new System.Drawing.Size(170, 6);
            // 
            // stripMenu_btnModifica_btnTaglia
            // 
            this.stripMenu_btnModifica_btnTaglia.Image = ((System.Drawing.Image)(resources.GetObject("stripMenu_btnModifica_btnTaglia.Image")));
            this.stripMenu_btnModifica_btnTaglia.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripMenu_btnModifica_btnTaglia.Name = "stripMenu_btnModifica_btnTaglia";
            this.stripMenu_btnModifica_btnTaglia.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.X)));
            this.stripMenu_btnModifica_btnTaglia.Size = new System.Drawing.Size(173, 22);
            this.stripMenu_btnModifica_btnTaglia.Text = "&Taglia";
            // 
            // stripMenu_btnModifica_btnCopia
            // 
            this.stripMenu_btnModifica_btnCopia.Image = ((System.Drawing.Image)(resources.GetObject("stripMenu_btnModifica_btnCopia.Image")));
            this.stripMenu_btnModifica_btnCopia.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripMenu_btnModifica_btnCopia.Name = "stripMenu_btnModifica_btnCopia";
            this.stripMenu_btnModifica_btnCopia.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.C)));
            this.stripMenu_btnModifica_btnCopia.Size = new System.Drawing.Size(173, 22);
            this.stripMenu_btnModifica_btnCopia.Text = "&Copia";
            // 
            // stripMenu_btnModifica_btnIncolla
            // 
            this.stripMenu_btnModifica_btnIncolla.Image = ((System.Drawing.Image)(resources.GetObject("stripMenu_btnModifica_btnIncolla.Image")));
            this.stripMenu_btnModifica_btnIncolla.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripMenu_btnModifica_btnIncolla.Name = "stripMenu_btnModifica_btnIncolla";
            this.stripMenu_btnModifica_btnIncolla.ShortcutKeys = ((System.Windows.Forms.Keys)((System.Windows.Forms.Keys.Control | System.Windows.Forms.Keys.V)));
            this.stripMenu_btnModifica_btnIncolla.Size = new System.Drawing.Size(173, 22);
            this.stripMenu_btnModifica_btnIncolla.Text = "&Incolla";
            // 
            // toolStripSeparator4
            // 
            this.toolStripSeparator4.Name = "toolStripSeparator4";
            this.toolStripSeparator4.Size = new System.Drawing.Size(170, 6);
            // 
            // stripMenu_btnModifica_btnSelezionaTutto
            // 
            this.stripMenu_btnModifica_btnSelezionaTutto.Name = "stripMenu_btnModifica_btnSelezionaTutto";
            this.stripMenu_btnModifica_btnSelezionaTutto.Size = new System.Drawing.Size(173, 22);
            this.stripMenu_btnModifica_btnSelezionaTutto.Text = "Seleziona &tutto";
            // 
            // stripMenu_btnVisualizza
            // 
            this.stripMenu_btnVisualizza.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stripMenu_btnVisualizza_btnGerarchia,
            this.stripMenu_btnVisualizza_btnDatabase,
            this.stripMenu_btnVisualizza_btnTools,
            this.stripMenu_btnVisualizza_btnInfo});
            this.stripMenu_btnVisualizza.Name = "stripMenu_btnVisualizza";
            this.stripMenu_btnVisualizza.Size = new System.Drawing.Size(69, 20);
            this.stripMenu_btnVisualizza.Text = "Visualizza";
            // 
            // stripMenu_btnVisualizza_btnGerarchia
            // 
            this.stripMenu_btnVisualizza_btnGerarchia.Checked = true;
            this.stripMenu_btnVisualizza_btnGerarchia.CheckState = System.Windows.Forms.CheckState.Checked;
            this.stripMenu_btnVisualizza_btnGerarchia.Name = "stripMenu_btnVisualizza_btnGerarchia";
            this.stripMenu_btnVisualizza_btnGerarchia.Size = new System.Drawing.Size(124, 22);
            this.stripMenu_btnVisualizza_btnGerarchia.Text = "Gerarchia";
            this.stripMenu_btnVisualizza_btnGerarchia.Click += new System.EventHandler(this.stripMenu_btnVisualizza_btnGerarchia_Click);
            // 
            // stripMenu_btnVisualizza_btnDatabase
            // 
            this.stripMenu_btnVisualizza_btnDatabase.Checked = true;
            this.stripMenu_btnVisualizza_btnDatabase.CheckState = System.Windows.Forms.CheckState.Checked;
            this.stripMenu_btnVisualizza_btnDatabase.Name = "stripMenu_btnVisualizza_btnDatabase";
            this.stripMenu_btnVisualizza_btnDatabase.Size = new System.Drawing.Size(124, 22);
            this.stripMenu_btnVisualizza_btnDatabase.Text = "Database";
            this.stripMenu_btnVisualizza_btnDatabase.Click += new System.EventHandler(this.stripMenu_btnVisualizza_btnDatabase_Click);
            // 
            // stripMenu_btnVisualizza_btnTools
            // 
            this.stripMenu_btnVisualizza_btnTools.Checked = true;
            this.stripMenu_btnVisualizza_btnTools.CheckState = System.Windows.Forms.CheckState.Checked;
            this.stripMenu_btnVisualizza_btnTools.Name = "stripMenu_btnVisualizza_btnTools";
            this.stripMenu_btnVisualizza_btnTools.Size = new System.Drawing.Size(124, 22);
            this.stripMenu_btnVisualizza_btnTools.Text = "Tools";
            this.stripMenu_btnVisualizza_btnTools.Click += new System.EventHandler(this.stripMenu_btnVisualizza_btnTools_Click);
            // 
            // stripMenu_btnVisualizza_btnInfo
            // 
            this.stripMenu_btnVisualizza_btnInfo.Checked = true;
            this.stripMenu_btnVisualizza_btnInfo.CheckState = System.Windows.Forms.CheckState.Checked;
            this.stripMenu_btnVisualizza_btnInfo.Name = "stripMenu_btnVisualizza_btnInfo";
            this.stripMenu_btnVisualizza_btnInfo.Size = new System.Drawing.Size(124, 22);
            this.stripMenu_btnVisualizza_btnInfo.Text = "Info";
            this.stripMenu_btnVisualizza_btnInfo.Click += new System.EventHandler(this.stripMenu_btnVisualizza_btnInfo_Click);
            // 
            // stripMenu_btnStrumenti
            // 
            this.stripMenu_btnStrumenti.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stripMenu_btnStrumenti_btnPersonalizza,
            this.stripMenu_btnStrumenti_btnOpzioni});
            this.stripMenu_btnStrumenti.Name = "stripMenu_btnStrumenti";
            this.stripMenu_btnStrumenti.Size = new System.Drawing.Size(71, 20);
            this.stripMenu_btnStrumenti.Text = "&Strumenti";
            // 
            // stripMenu_btnStrumenti_btnPersonalizza
            // 
            this.stripMenu_btnStrumenti_btnPersonalizza.Name = "stripMenu_btnStrumenti_btnPersonalizza";
            this.stripMenu_btnStrumenti_btnPersonalizza.Size = new System.Drawing.Size(138, 22);
            this.stripMenu_btnStrumenti_btnPersonalizza.Text = "&Personalizza";
            // 
            // stripMenu_btnStrumenti_btnOpzioni
            // 
            this.stripMenu_btnStrumenti_btnOpzioni.Name = "stripMenu_btnStrumenti_btnOpzioni";
            this.stripMenu_btnStrumenti_btnOpzioni.Size = new System.Drawing.Size(138, 22);
            this.stripMenu_btnStrumenti_btnOpzioni.Text = "&Opzioni";
            // 
            // stripMenu_btnInfo
            // 
            this.stripMenu_btnInfo.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stripMenu_btnInfo_btnSommario,
            this.stripMenu_btnInfo_btnIndice,
            this.stripMenu_btnInfo_btnCerca,
            this.toolStripSeparator5,
            this.stripMenu_btnInfo_btnInfo});
            this.stripMenu_btnInfo.Name = "stripMenu_btnInfo";
            this.stripMenu_btnInfo.Size = new System.Drawing.Size(24, 20);
            this.stripMenu_btnInfo.Text = "&?";
            // 
            // stripMenu_btnInfo_btnSommario
            // 
            this.stripMenu_btnInfo_btnSommario.Name = "stripMenu_btnInfo_btnSommario";
            this.stripMenu_btnInfo_btnSommario.Size = new System.Drawing.Size(165, 22);
            this.stripMenu_btnInfo_btnSommario.Text = "&Sommario";
            // 
            // stripMenu_btnInfo_btnIndice
            // 
            this.stripMenu_btnInfo_btnIndice.Name = "stripMenu_btnInfo_btnIndice";
            this.stripMenu_btnInfo_btnIndice.Size = new System.Drawing.Size(165, 22);
            this.stripMenu_btnInfo_btnIndice.Text = "&Indice";
            // 
            // stripMenu_btnInfo_btnCerca
            // 
            this.stripMenu_btnInfo_btnCerca.Name = "stripMenu_btnInfo_btnCerca";
            this.stripMenu_btnInfo_btnCerca.Size = new System.Drawing.Size(165, 22);
            this.stripMenu_btnInfo_btnCerca.Text = "&Cerca";
            // 
            // toolStripSeparator5
            // 
            this.toolStripSeparator5.Name = "toolStripSeparator5";
            this.toolStripSeparator5.Size = new System.Drawing.Size(162, 6);
            // 
            // stripMenu_btnInfo_btnInfo
            // 
            this.stripMenu_btnInfo_btnInfo.Name = "stripMenu_btnInfo_btnInfo";
            this.stripMenu_btnInfo_btnInfo.Size = new System.Drawing.Size(165, 22);
            this.stripMenu_btnInfo_btnInfo.Text = "&Informazioni su...";
            // 
            // stripTools
            // 
            this.stripTools.Anchor = ((System.Windows.Forms.AnchorStyles)(((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Left) 
            | System.Windows.Forms.AnchorStyles.Right)));
            this.stripTools.Dock = System.Windows.Forms.DockStyle.None;
            this.stripTools.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.stripTools_btnEdit,
            this.stripTools_btnDelete,
            this.toolStripSeparator6,
            this.stripTools_btnAdd,
            this.stripTools_btnRefresh,
            this.stripTools_btnSearch});
            this.stripTools.Location = new System.Drawing.Point(3, 24);
            this.stripTools.Name = "stripTools";
            this.stripTools.Size = new System.Drawing.Size(133, 25);
            this.stripTools.TabIndex = 1;
            // 
            // stripTools_btnEdit
            // 
            this.stripTools_btnEdit.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.stripTools_btnEdit.Image = ((System.Drawing.Image)(resources.GetObject("stripTools_btnEdit.Image")));
            this.stripTools_btnEdit.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripTools_btnEdit.Name = "stripTools_btnEdit";
            this.stripTools_btnEdit.Size = new System.Drawing.Size(23, 22);
            this.stripTools_btnEdit.Text = "Modifica";
            this.stripTools_btnEdit.Click += new System.EventHandler(this.stripTools_btnEdit_Click);
            // 
            // stripTools_btnDelete
            // 
            this.stripTools_btnDelete.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.stripTools_btnDelete.Image = ((System.Drawing.Image)(resources.GetObject("stripTools_btnDelete.Image")));
            this.stripTools_btnDelete.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripTools_btnDelete.Name = "stripTools_btnDelete";
            this.stripTools_btnDelete.Size = new System.Drawing.Size(23, 22);
            this.stripTools_btnDelete.Text = "Elimina";
            this.stripTools_btnDelete.Click += new System.EventHandler(this.stripTools_btnDelete_Click);
            // 
            // toolStripSeparator6
            // 
            this.toolStripSeparator6.Name = "toolStripSeparator6";
            this.toolStripSeparator6.Size = new System.Drawing.Size(6, 25);
            // 
            // stripTools_btnAdd
            // 
            this.stripTools_btnAdd.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.stripTools_btnAdd.Image = ((System.Drawing.Image)(resources.GetObject("stripTools_btnAdd.Image")));
            this.stripTools_btnAdd.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripTools_btnAdd.Name = "stripTools_btnAdd";
            this.stripTools_btnAdd.Size = new System.Drawing.Size(23, 22);
            this.stripTools_btnAdd.Text = "Aggiungi";
            this.stripTools_btnAdd.Click += new System.EventHandler(this.stripTools_btnAdd_Click);
            // 
            // stripTools_btnRefresh
            // 
            this.stripTools_btnRefresh.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.stripTools_btnRefresh.Image = ((System.Drawing.Image)(resources.GetObject("stripTools_btnRefresh.Image")));
            this.stripTools_btnRefresh.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripTools_btnRefresh.Name = "stripTools_btnRefresh";
            this.stripTools_btnRefresh.Size = new System.Drawing.Size(23, 22);
            this.stripTools_btnRefresh.Text = "Aggiorna Vista";
            this.stripTools_btnRefresh.Click += new System.EventHandler(this.stripTools_btnRefresh_Click);
            // 
            // stripTools_btnSearch
            // 
            this.stripTools_btnSearch.Alignment = System.Windows.Forms.ToolStripItemAlignment.Right;
            this.stripTools_btnSearch.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.stripTools_btnSearch.Image = ((System.Drawing.Image)(resources.GetObject("stripTools_btnSearch.Image")));
            this.stripTools_btnSearch.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.stripTools_btnSearch.Name = "stripTools_btnSearch";
            this.stripTools_btnSearch.Size = new System.Drawing.Size(23, 22);
            this.stripTools_btnSearch.Text = "Cerca";
            this.stripTools_btnSearch.Click += new System.EventHandler(this.stripTools_btnSearch_Click);
            // 
            // frmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1072, 615);
            this.Controls.Add(this.toolStripContainer);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "frmMain";
            this.Text = "Database Hardware";
            this.toolStripContainer.BottomToolStripPanel.ResumeLayout(false);
            this.toolStripContainer.BottomToolStripPanel.PerformLayout();
            this.toolStripContainer.ContentPanel.ResumeLayout(false);
            this.toolStripContainer.TopToolStripPanel.ResumeLayout(false);
            this.toolStripContainer.TopToolStripPanel.PerformLayout();
            this.toolStripContainer.ResumeLayout(false);
            this.toolStripContainer.PerformLayout();
            this.stripInfo.ResumeLayout(false);
            this.stripInfo.PerformLayout();
            this.tabControlRight.ResumeLayout(false);
            this.tabPageRight.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridViewDatabase)).EndInit();
            this.tabControlLeft.ResumeLayout(false);
            this.tabPageLeft.ResumeLayout(false);
            this.stripMenu.ResumeLayout(false);
            this.stripMenu.PerformLayout();
            this.stripTools.ResumeLayout(false);
            this.stripTools.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.ToolStripContainer toolStripContainer;
        private System.Windows.Forms.StatusStrip stripInfo;
        private System.Windows.Forms.ToolStripStatusLabel stripInfo_lblInfo;
        private System.Windows.Forms.MenuStrip stripMenu;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnFile;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnFile_btnNuovo;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnFile_btnApri;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnFile_btnSalva;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnFile_btnSalva2;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator1;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnFile_btnStampa;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnFile_btnStampa2;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator2;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnFile_btnEsci;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnModifica;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnModifica_btnAnnulla;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnModifica_btnRipristina;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator3;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnModifica_btnTaglia;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnModifica_btnCopia;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnModifica_btnIncolla;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator4;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnModifica_btnSelezionaTutto;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnVisualizza;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnStrumenti;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnStrumenti_btnPersonalizza;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnStrumenti_btnOpzioni;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnInfo;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnInfo_btnSommario;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnInfo_btnIndice;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnInfo_btnCerca;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator5;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnInfo_btnInfo;
        private System.Windows.Forms.ToolStrip stripTools;
        private System.Windows.Forms.ToolStripButton stripTools_btnAdd;
        private System.Windows.Forms.ToolStripButton stripTools_btnSearch;
        private System.Windows.Forms.ToolStripSeparator toolStripSeparator6;
        private System.Windows.Forms.ToolStripButton stripTools_btnEdit;
        private System.Windows.Forms.ToolStripButton stripTools_btnDelete;
        private System.Windows.Forms.TabControl tabControlRight;
        private System.Windows.Forms.TabPage tabPageRight;
        public System.Windows.Forms.DataGridView dataGridViewDatabase;
        private System.Windows.Forms.ToolStripButton stripTools_btnRefresh;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnVisualizza_btnGerarchia;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnVisualizza_btnTools;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnVisualizza_btnDatabase;
        private System.Windows.Forms.ToolStripMenuItem stripMenu_btnVisualizza_btnInfo;
        private System.Windows.Forms.TabControl tabControlLeft;
        private System.Windows.Forms.TabPage tabPageLeft;
        private System.Windows.Forms.TreeView treeViewDatabase;
    }
}

