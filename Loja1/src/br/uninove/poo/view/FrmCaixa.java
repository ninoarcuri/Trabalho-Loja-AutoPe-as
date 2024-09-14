/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.poo.view;

import br.uninove.poo.dao.CaixaDAO;
import br.uninove.poo.dao.CarroDAO;
import br.uninove.poo.dao.ClienteDAO;
import br.uninove.poo.dao.Conexao;
import br.uninove.poo.negocio.Caixa;
import br.uninove.poo.negocio.Carro;
import br.uninove.poo.negocio.Cliente;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Internet
 */
public class FrmCaixa extends javax.swing.JFrame {

    List<Caixa> listaCaixa = new ArrayList<>();
    List<Carro> listaCarros = new ArrayList<>();
    List<Cliente> listaCliente = new ArrayList<>();
    List<Caixa> listvendas = new ArrayList<>();
    CarroDAO Prod = new CarroDAO();
    Caixa mod = new Caixa();
    ClienteDAO Pod = new ClienteDAO();

    public FrmCaixa() {
        initComponents();
        this.setLocationRelativeTo(null);//centraliza

    }

    public List<Carro> getListarCarroBU() {
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();
        String sql = ("SELECT * FROM carros WHERE peca like '%" + txtProduto.getText() + "%'");
        List<Carro> listCarros = new ArrayList<>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Carro objCarro = new Carro();
                objCarro.setIdCarro(resultado.getInt("idCarro"));
                objCarro.setAnoFabricacao(resultado.getInt("anoFabricacao"));
                objCarro.setCor(resultado.getString("cor"));
                objCarro.setFabricante(resultado.getString("fabricante"));
                objCarro.setPeca(resultado.getString("peca"));
                objCarro.setModelo(resultado.getString("modelo"));
                objCarro.setValor(resultado.getDouble("valor"));
                objCarro.setQuat(resultado.getInt("quantidade"));
                listCarros.add(objCarro);
            }
        } catch (SQLException ex) {

        }
        return listCarros;
    }

    public List<Cliente> getListarClienteBU() {
        Conexao conn = new Conexao();
        Connection conexao = conn.getConexao();
        String sql = ("SELECT * FROM cliente WHERE nomeCli like '%" + txtCliente.getText() + "%'");
        List<Cliente> listCliente = new ArrayList<>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Cliente objCliente = new Cliente();
                objCliente.setIdCli(resultado.getInt("idCli"));
                objCliente.setNomecli(resultado.getString("nomeCli"));
                objCliente.setCNPJ(resultado.getString("cnpj"));
                objCliente.setEmail(resultado.getString("email"));
                objCliente.setEndereco(resultado.getString("endereco"));
                objCliente.setBairro(resultado.getString("bairro"));
                objCliente.setCidade(resultado.getString("cidade"));
                objCliente.setUf(resultado.getString("uf"));
                objCliente.setCEP(resultado.getString("CEP"));
                objCliente.setTel(resultado.getString("tel"));
                objCliente.setCel(resultado.getString("cel"));
                listCliente.add(objCliente);
            }
        } catch (SQLException ex) {

        }
        return listCliente;
    }

    private void loadCarros() {
        listaCarros = getListarCarroBU();
        Object[] row = new Object[8];
        DefaultTableModel tabela = (DefaultTableModel) tbp.getModel();

        for (Carro carroLocal : listaCarros) {
            row[0] = carroLocal.getIdCarro();
            row[1] = carroLocal.getPeca();
            row[2] = carroLocal.getFabricante();
            row[3] = carroLocal.getModelo();
            row[5] = carroLocal.getAnoFabricacao();
            row[4] = carroLocal.getCor();
            row[6] = carroLocal.getValor();
            row[7] = carroLocal.getQuat();

            tabela.addRow(row);
        }
    }

    private void loadCliente() {
        listaCliente = getListarClienteBU();
        Object[] row = new Object[2];
        DefaultTableModel tabela = (DefaultTableModel) tbbCliente.getModel();

        for (Cliente clienteLocal : listaCliente) {
            row[0] = clienteLocal.getIdCli();
            row[1] = clienteLocal.getNomecli();

            tabela.addRow(row);
        }
    }

    private void cleanForm() {
        txtProduto.setText("");
        txtValor.setText("");
        txtQuant.setText("");
        txtidp.setText("");
        txtCliente.setText("");
        txtData.setText("");
    }

    private void cleanTable() {
        DefaultTableModel tabela = (DefaultTableModel) tbp.getModel();
        while (tabela.getRowCount() > 0) {
            for (int i = 0; i < tabela.getRowCount(); i++) {
                tabela.removeRow(i);

            }
        }
    }

    private void cleanTable2() {
        DefaultTableModel tabela = (DefaultTableModel) tbv.getModel();
        while (tabela.getRowCount() > 0) {
            for (int i = 0; i < tabela.getRowCount(); i++) {
                tabela.removeRow(i);

            }
        }
    }

    private void cleanTable3() {
        DefaultTableModel tabela = (DefaultTableModel) tbbCliente.getModel();
        while (tabela.getRowCount() > 0) {
            for (int i = 0; i < tabela.getRowCount(); i++) {
                tabela.removeRow(i);

            }
        }
    }

    private void cleanTable4() {
        DefaultTableModel tabela = (DefaultTableModel) tbR.getModel();
        while (tabela.getRowCount() > 0) {
            for (int i = 0; i < tabela.getRowCount(); i++) {
                tabela.removeRow(i);

            }
        }
    }

    private Caixa getObjCaixa() {
        Caixa objCaixa = new Caixa();

        objCaixa.setNomeProduto(txtProduto.getText());

        objCaixa.setNomeCliente(txtCliente.getText());

        objCaixa.setData(txtData.getText());
        float valor = Float.parseFloat(txtValor.getText());
        objCaixa.setValorVenda(valor);

        int id = Integer.parseInt(txtidp.getText());
        objCaixa.setIdVenda(id);

        int quant = Integer.parseInt(txtQuant.getText());
        objCaixa.setQauntItem(quant);

        return objCaixa;
    }

    private Caixa getObjVendas() {
        Caixa objCaixa = new Caixa();

        objCaixa.setNomeProduto(txtProduto.getText());
        objCaixa.setNomeProduto(txtCliente.getText());
        objCaixa.setData(txtData.getText());
        float valor = Float.parseFloat(txtValor.getText());
        objCaixa.setValorVenda(valor);
        int quant = Integer.parseInt(txtQuant.getText());
        objCaixa.setQauntItem(quant);

        return objCaixa;
    }

    public List<Caixa> getListarCaixas() {
        Conexao conn = new Conexao();
        java.sql.Connection conexao = conn.getConexao();
        String sql = "SELECT * FROM caixa";
        List<Caixa> listCarros = new ArrayList<>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Caixa objCaixa = new Caixa();
                objCaixa.setIdVenda(resultado.getInt("idCarro"));
                objCaixa.setQauntItem(resultado.getInt("quantidade"));
                objCaixa.setData(resultado.getString("data_venda"));
                objCaixa.setNomeProduto(resultado.getString("peca"));
                objCaixa.setValorVenda(resultado.getFloat("valor"));
                listCarros.add(objCaixa);
            }
        } catch (SQLException ex) {

        }
        return listCarros;
    }

    private void loadvendas() {
        listaCaixa = getListarCaixas();
        Object[] row = new Object[4];
        DefaultTableModel tabela = (DefaultTableModel) tbv.getModel();

        for (Caixa carroLocal : listaCaixa) {
            row[0] = carroLocal.getNomeProduto();
            row[1] = carroLocal.getQauntItem();
            row[2] = carroLocal.getValorVenda();
            row[3] = carroLocal.getIdVenda();
            tabela.addRow(row);
        }
    }

    public List<Caixa> getListarvendas() {
        Conexao conn = new Conexao();
        java.sql.Connection conexao = conn.getConexao();
        String sql = "SELECT * FROM vendas";
        List<Caixa> listCarros = new ArrayList<>();
        try {
            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Caixa objCaixa = new Caixa();
                objCaixa.setNomeCliente(resultado.getString("nomeClie"));
                objCaixa.setQauntItem(resultado.getInt("quantidade"));
                objCaixa.setData(resultado.getString("data_venda"));
                objCaixa.setNomeProduto(resultado.getString("peca"));
                objCaixa.setValorVenda(resultado.getFloat("valor"));
                listCarros.add(objCaixa);
            }
        } catch (SQLException ex) {

        }
        return listCarros;
    }

    private void loadvendasR() {
        listaCaixa = getListarvendas();
        Object[] row = new Object[5];
        DefaultTableModel tabela = (DefaultTableModel) tbR.getModel();

        for (Caixa carroLocal : listaCaixa) {
            row[0] = carroLocal.getData();
            row[1] = carroLocal.getNomeProduto();
            row[2] = carroLocal.getQauntItem();
            row[3] = carroLocal.getValorVenda();
            row[4] = carroLocal.getNomeCliente();
            tabela.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbp = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtData = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        txtValor = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        txtDataFin = new javax.swing.JTextField();
        txtDataIni = new javax.swing.JTextField();
        BUSCACLIENTE = new javax.swing.JButton();
        BUSCAPRDUTO = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        Add = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbv = new javax.swing.JTable();
        jButtonFV = new javax.swing.JButton();
        jButtonCV = new javax.swing.JButton();
        txtidp = new javax.swing.JTextField();
        jButtonNovo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbbCliente = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbR = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(151, 151, 151));

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jPanel4.setBackground(new java.awt.Color(102, 102, 102));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Fluxo de Caixa");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Voltar");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("X");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 51));
        jLabel12.setText("-");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Data:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Produto:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Valor:");

        tbp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PEÇA", "FABRICANTE", "MODELO", "ANO/FABRICAÇÃO", "COR", "VALOR", "QUANTIDADE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbp.getTableHeader().setReorderingAllowed(false);
        tbp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbp);
        if (tbp.getColumnModel().getColumnCount() > 0) {
            tbp.getColumnModel().getColumn(0).setResizable(false);
            tbp.getColumnModel().getColumn(1).setResizable(false);
            tbp.getColumnModel().getColumn(2).setResizable(false);
            tbp.getColumnModel().getColumn(3).setResizable(false);
            tbp.getColumnModel().getColumn(4).setResizable(false);
            tbp.getColumnModel().getColumn(5).setResizable(false);
            tbp.getColumnModel().getColumn(6).setResizable(false);
            tbp.getColumnModel().getColumn(7).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Cliente:");

        txtData.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDataFocusGained(evt);
            }
        });
        txtData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDataMouseClicked(evt);
            }
        });

        txtProduto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtValor.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jToggleButton1.setBackground(new java.awt.Color(204, 204, 204));
        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jToggleButton1.setText("Imprimir Relatório");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("até");

        txtDataFin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDataFin.setToolTipText("");

        txtDataIni.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtDataIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataIniActionPerformed(evt);
            }
        });

        BUSCACLIENTE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BUSCACLIENTE.setText("BUSCA");
        BUSCACLIENTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCACLIENTEActionPerformed(evt);
            }
        });

        BUSCAPRDUTO.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        BUSCAPRDUTO.setText("BUSCA");
        BUSCAPRDUTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUSCAPRDUTOActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Quantidade:");

        txtQuant.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtQuant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQuantFocusGained(evt);
            }
        });

        Add.setBackground(new java.awt.Color(0, 153, 51));
        Add.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Add.setForeground(new java.awt.Color(255, 255, 255));
        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        tbv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Peça", "Quantidade", "Valor", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbv.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbv);

        jButtonFV.setText("Finalizar Venda");
        jButtonFV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFVActionPerformed(evt);
            }
        });

        jButtonCV.setText("Cancela Venda");
        jButtonCV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCVActionPerformed(evt);
            }
        });

        txtidp.setEnabled(false);

        jButtonNovo.setBackground(new java.awt.Color(255, 255, 255));
        jButtonNovo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        tbbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbbCliente.getTableHeader().setReorderingAllowed(false);
        tbbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbClienteMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbbCliente);
        if (tbbCliente.getColumnModel().getColumnCount() > 0) {
            tbbCliente.getColumnModel().getColumn(0).setMinWidth(40);
            tbbCliente.getColumnModel().getColumn(0).setMaxWidth(40);
            tbbCliente.getColumnModel().getColumn(1).setResizable(false);
        }

        tbR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Produto", "Quantidade", "Valor", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbR);
        if (tbR.getColumnModel().getColumnCount() > 0) {
            tbR.getColumnModel().getColumn(0).setMinWidth(100);
            tbR.getColumnModel().getColumn(0).setMaxWidth(100);
            tbR.getColumnModel().getColumn(2).setMinWidth(100);
            tbR.getColumnModel().getColumn(2).setMaxWidth(100);
            tbR.getColumnModel().getColumn(3).setMinWidth(100);
            tbR.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setBackground(new java.awt.Color(102, 102, 102));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Registro de Vendas");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tabela de Pesquisa:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Itens da Venda:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(869, 869, 869)
                                .addComponent(jButtonFV)
                                .addGap(39, 39, 39)
                                .addComponent(jButtonCV))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BUSCAPRDUTO)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Add, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 98, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BUSCACLIENTE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDataFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1)
                        .addGap(18, 18, 18)
                        .addComponent(txtidp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtDataFin, txtDataIni});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCliente, txtProduto});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtidp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BUSCACLIENTE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDataIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtDataFin)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BUSCAPRDUTO)
                    .addComponent(jButtonNovo)
                    .addComponent(Add))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6)
                        .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCV)
                    .addComponent(jButtonFV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCliente, txtData, txtProduto});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDataFin, txtDataIni});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        JOptionPane.showMessageDialog(this, "Nenhum Relatório Encontrado");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void txtDataIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataIniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataIniActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void BUSCACLIENTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCACLIENTEActionPerformed
        loadCliente();
    }//GEN-LAST:event_BUSCACLIENTEActionPerformed

    private void BUSCAPRDUTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUSCAPRDUTOActionPerformed
        loadCarros();
    }//GEN-LAST:event_BUSCAPRDUTOActionPerformed

    private void tbpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpMouseClicked
        int rowSelected = tbp.getSelectedRow();
        TableModel tabela = tbp.getModel();
        int id = Integer.parseInt(tabela.getValueAt(rowSelected, 0).toString());
        txtQuant.setText("1");
        Carro carroSelected = null;
        for (Carro item : listaCarros) {
            if (item.getIdCarro() == id) {
                carroSelected = item;
            }
        }
        txtidp.setText(Integer.toString(id));
        txtProduto.setText(carroSelected.getPeca());
        txtValor.setText(Double.toString(carroSelected.getValor()));


    }//GEN-LAST:event_tbpMouseClicked

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        cleanForm();//limpar o fomulario
        cleanTable();//limpar tabela para carregar todos os dados
        cleanTable3();
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void txtQuantFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQuantFocusGained


    }//GEN-LAST:event_txtQuantFocusGained

    private void txtDataFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDataFocusGained

    }//GEN-LAST:event_txtDataFocusGained

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        Caixa objCaixa = getObjCaixa();
        CaixaDAO dbCaixa = new CaixaDAO();
        dbCaixa.inserir(objCaixa);
        dbCaixa.inserir2(objCaixa);
        cleanForm();//limpar o fomulario
        cleanTable();//limpar tabela para carregar todos os dados
        cleanTable2();//limpar tabela para carregar todos os dados
        loadvendas();
    }//GEN-LAST:event_AddActionPerformed

    private void jButtonFVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFVActionPerformed
        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();
            String sql = "truncate caixa";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Venda Finalizada");
            cleanTable2();//limpar tabela para carregar todos os dados
            loadvendas();
            loadvendasR();
            cleanTable4();
            loadvendasR();
        } catch (SQLException e) {
        }

    }//GEN-LAST:event_jButtonFVActionPerformed

    private void jButtonCVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCVActionPerformed
        try {
            Conexao conn = new Conexao();
            Connection conexao = conn.getConexao();
            String sql = "truncate caixa";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(this, "Venda Cancelada");
            cleanTable2();//limpar tabela para carregar todos os dados
            loadvendas();
        } catch (SQLException e) {
        }
    }//GEN-LAST:event_jButtonCVActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        Menu MVMC = new Menu();
        MVMC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void tbbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbClienteMouseClicked
        int rowSelected = tbbCliente.getSelectedRow();
        TableModel tabela = tbbCliente.getModel();
        int id = Integer.parseInt(tabela.getValueAt(rowSelected, 0).toString());

        Cliente clienteSelectd = null;
        for (Cliente item : listaCliente) {
            if (item.getIdCli() == id) {
                clienteSelectd = item;
                cleanTable3();
            }
        }

        txtCliente.setText(clienteSelectd.getNomecli());
    }//GEN-LAST:event_tbbClienteMouseClicked

    private void txtDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataMouseClicked

    }//GEN-LAST:event_txtDataMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton BUSCACLIENTE;
    private javax.swing.JButton BUSCAPRDUTO;
    private javax.swing.JButton jButtonCV;
    private javax.swing.JButton jButtonFV;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tbR;
    private javax.swing.JTable tbbCliente;
    private javax.swing.JTable tbp;
    private javax.swing.JTable tbv;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDataFin;
    private javax.swing.JTextField txtDataIni;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txtValor;
    private javax.swing.JTextField txtidp;
    // End of variables declaration//GEN-END:variables
}
