package br.uninove.poo.view;

import br.uninove.poo.dao.ClienteDAO;
import br.uninove.poo.negocio.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class FrmCadastroCli extends javax.swing.JFrame {

    List<Cliente> listaCliente = new ArrayList<>();

    public FrmCadastroCli() {
        initComponents();
        loadCliente();
        this.setLocationRelativeTo(null);//centraliza
    }

    private void loadCliente() {
        ClienteDAO clientebd = new ClienteDAO();
        listaCliente = clientebd.getListarCliente();
        Object[] row = new Object[11];
        DefaultTableModel tabela = (DefaultTableModel) GridCliente.getModel();

        for (Cliente clienteLocal : listaCliente) {
            row[0] = clienteLocal.getIdCli();
            row[1] = clienteLocal.getNomecli();
            row[2] = clienteLocal.getCNPJ();
            row[3] = clienteLocal.getEmail();
            row[5] = clienteLocal.getEndereco();
            row[4] = clienteLocal.getBairro();
            row[6] = clienteLocal.getCidade();
            row[7] = clienteLocal.getUf();
            row[8] = clienteLocal.getCEP();
            row[9] = clienteLocal.getTel();
            row[10] = clienteLocal.getCel();
            tabela.addRow(row);
        }
    }

    private void enableButtonEdit() {
        btalterar.setEnabled(true);
        btexcluir.setEnabled(true);
        btinserir.setEnabled(false);
        btnovo.setEnabled(true);
    }

    private void enableButtonNovo() {
        btalterar.setEnabled(false);
        btexcluir.setEnabled(false);
        btinserir.setEnabled(true);
        btnovo.setEnabled(false);
    }

    private void cleanForm() {
        txtIdCli.setText("");
        txtNomeCli.setText("");
        txtCNPJ.setText("");
        txtEmailCli.setText("");
        txtEnderecoCli.setText("");
        txtBairroCli.setText("");
        txtCidadeCli.setText("");
        txtUFCli.setText("");
        txtCEPCli.setText("");
        txtTelefoneCli.setText("");
        txtCelularCli.setText("");

    }

    private void cleanTable() {
        DefaultTableModel tabela = (DefaultTableModel) GridCliente.getModel();
        while (tabela.getRowCount() > 0) {
            for (int i = 0; i < tabela.getRowCount(); i++) {
                tabela.removeRow(i);

            }
        }
    }

    private Cliente getObjCliente() {
        Cliente objCliente = new Cliente();

        objCliente.setNomecli(txtNomeCli.getText());
        objCliente.setCNPJ(txtCNPJ.getText());
        objCliente.setEmail(txtEmailCli.getText());
        objCliente.setEndereco(txtEnderecoCli.getText());
        objCliente.setBairro(txtBairroCli.getText());
        objCliente.setCidade(txtCidadeCli.getText());
        objCliente.setUf(txtUFCli.getText());
        objCliente.setCEP(txtCEPCli.getText());
        objCliente.setTel(txtTelefoneCli.getText());
        objCliente.setCel(txtCelularCli.getText());

        return objCliente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtEnderecoCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtBairroCli = new javax.swing.JTextField();
        txtCidadeCli = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtUFCli = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtCEPCli = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtTelefoneCli = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCelularCli = new javax.swing.JTextField();
        txtIdCli = new javax.swing.JTextField();
        txtNomeCli = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCNPJ = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmailCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btinserir = new javax.swing.JButton();
        btnovo = new javax.swing.JButton();
        btalterar = new javax.swing.JButton();
        btexcluir = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        GridCliente = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(151, 151, 151));

        txtEnderecoCli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEnderecoCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEnderecoCliActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Endereço:");

        txtBairroCli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtCidadeCli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("UF:");

        txtUFCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("CEP:");

        txtCEPCli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCEPCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCEPCliActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Telefone:");

        txtTelefoneCli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Celular:");

        txtCelularCli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtIdCli.setEditable(false);
        txtIdCli.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdCli.setEnabled(false);

        txtNomeCli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("CPF/CNPJ:");

        txtCNPJ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("E-mail:");

        txtEmailCli.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID:");

        btinserir.setBackground(new java.awt.Color(0, 153, 51));
        btinserir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btinserir.setForeground(new java.awt.Color(255, 255, 255));
        btinserir.setText("Inserir");
        btinserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btinserirActionPerformed(evt);
            }
        });

        btnovo.setBackground(new java.awt.Color(255, 255, 255));
        btnovo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnovo.setText("Novo");
        btnovo.setEnabled(false);
        btnovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnovoActionPerformed(evt);
            }
        });

        btalterar.setBackground(new java.awt.Color(255, 153, 0));
        btalterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btalterar.setForeground(new java.awt.Color(255, 255, 255));
        btalterar.setText("Alterar");
        btalterar.setEnabled(false);
        btalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btalterarActionPerformed(evt);
            }
        });

        btexcluir.setBackground(new java.awt.Color(255, 51, 51));
        btexcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btexcluir.setForeground(new java.awt.Color(255, 255, 255));
        btexcluir.setText("Excluir");
        btexcluir.setEnabled(false);
        btexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btexcluirActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cadastro de Clientes");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 153, 153), new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("-");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("Voltar");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        GridCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        GridCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF/CNPJ", "Email", "Endereço", "Bairro", "Cidade", "UF", "CEP", "Telefone", "Celuar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        GridCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GridClienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(GridCliente);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Cidade:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Bairro:");

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Clientes Cadastrados:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBairroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addGap(1, 1, 1)
                                .addComponent(txtCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUFCli, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCEPCli, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCelularCli, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 47, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(9, 9, 9)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel3)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel7)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel6))
                                                .addComponent(txtEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(26, 26, 26)
                                            .addComponent(btinserir)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnovo)
                                            .addGap(18, 18, 18)
                                            .addComponent(btalterar)
                                            .addGap(18, 18, 18)
                                            .addComponent(btexcluir)))))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13)
                    .addComponent(txtUFCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCEPCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtTelefoneCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtCelularCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(365, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btinserir)
                        .addComponent(btnovo)
                        .addComponent(btalterar)
                        .addComponent(btexcluir))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel6)
                        .addComponent(txtEmailCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(txtEnderecoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(124, 124, 124)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCidadeCli, txtUFCli});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btinserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btinserirActionPerformed

        Cliente objCliente = getObjCliente();
        ClienteDAO dbCliente = new ClienteDAO();
        dbCliente.inserir(objCliente);

        cleanForm();//limpar o fomulario
        cleanTable();//limpar tabela para carregar todos os dados
        loadCliente();//carregar as informaçoes
    }//GEN-LAST:event_btinserirActionPerformed

    private void btnovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnovoActionPerformed
        enableButtonNovo();
        cleanForm();
    }//GEN-LAST:event_btnovoActionPerformed

    private void btalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btalterarActionPerformed
        Cliente objCliente = getObjCliente();
        ClienteDAO dbCliente = new ClienteDAO();
        int id = Integer.parseInt(txtIdCli.getText());
        objCliente.setIdCli(id);

        dbCliente.atualizar(objCliente);

        cleanForm();//limpar o fomulario
        cleanTable();//limpar tabela para carregar todos os dados
        loadCliente();//carregar as informaçoes
    }//GEN-LAST:event_btalterarActionPerformed

    private void btexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btexcluirActionPerformed
        Cliente objCliente = getObjCliente();
        ClienteDAO dbCliente = new ClienteDAO();
        int id = Integer.parseInt(txtIdCli.getText());
        objCliente.setIdCli(id);

        dbCliente.delete(id);

        cleanForm();//limpar o fomulario
        cleanTable();//limpar tabela para carregar todos os dados
        loadCliente();//carregar as informaçoes
    }//GEN-LAST:event_btexcluirActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        FrmMenuCadastro MVMC = new FrmMenuCadastro();
        MVMC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void GridClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GridClienteMouseClicked
        int rowSelected = GridCliente.getSelectedRow();
        TableModel tabela = GridCliente.getModel();
        int id = Integer.parseInt(tabela.getValueAt(rowSelected, 0).toString());

        Cliente clienteSelected = null;
        for (Cliente item : listaCliente) {
            if (item.getIdCli() == id) {
                clienteSelected = item;
            }
        }
        txtIdCli.setText(Integer.toString(id));
        txtNomeCli.setText(clienteSelected.getNomecli());
        txtCNPJ.setText(clienteSelected.getCNPJ());
        txtEmailCli.setText(clienteSelected.getEmail());
        txtEnderecoCli.setText(clienteSelected.getEndereco());
        txtBairroCli.setText(clienteSelected.getBairro());
        txtCidadeCli.setText(clienteSelected.getCidade());
        txtUFCli.setText(clienteSelected.getUf());
        txtCEPCli.setText(clienteSelected.getCEP());
        txtTelefoneCli.setText(clienteSelected.getTel());
        txtCelularCli.setText(clienteSelected.getCel());

        enableButtonEdit();
    }//GEN-LAST:event_GridClienteMouseClicked

    private void txtCEPCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCEPCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCEPCliActionPerformed

    private void txtEnderecoCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEnderecoCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEnderecoCliActionPerformed

    
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCadastroCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmCadastroCli().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable GridCliente;
    private javax.swing.JButton btalterar;
    private javax.swing.JButton btexcluir;
    private javax.swing.JButton btinserir;
    private javax.swing.JButton btnovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtBairroCli;
    private javax.swing.JTextField txtCEPCli;
    private javax.swing.JTextField txtCNPJ;
    private javax.swing.JTextField txtCelularCli;
    private javax.swing.JTextField txtCidadeCli;
    private javax.swing.JTextField txtEmailCli;
    private javax.swing.JTextField txtEnderecoCli;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtNomeCli;
    private javax.swing.JTextField txtTelefoneCli;
    private javax.swing.JTextField txtUFCli;
    // End of variables declaration//GEN-END:variables
}
