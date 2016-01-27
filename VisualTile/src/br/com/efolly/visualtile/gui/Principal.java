package br.com.efolly.visualtile.gui;

import br.com.efolly.visualtile.tile.Tile;
import br.com.efolly.visualtile.util.Config;
import br.com.efolly.visualtile.util.MessageConsole;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Eduardo Folly
 */
public class Principal extends JFrame implements Progresso {

    private File origem;
    private File destino;

    /**
     *
     */
    public Principal() {
        initComponents();

        MessageConsole mc = new MessageConsole(jTextArea1);
        mc.redirectOut();

        Config config = Config.getInstance();

        String nomeOrigem = config.getNomeOrigem();
        if (nomeOrigem != null && !nomeOrigem.isEmpty()) {
            origem = new File(nomeOrigem);
        }

        campoLimSuperior.setText(Double.toString(config.getLimSuperior()));

        campoLimEsquerdo.setText(Double.toString(config.getLimEsquerdo()));

        campoLimInferior.setText(Double.toString(config.getLimInferior()));

        campoLimDireito.setText(Double.toString(config.getLimDireito()));

        spinnerMinZoom.setValue(config.getMinZoom());

        spinnerMaxZoom.setValue(config.getMaxZoom());

        String nomeDestino = config.getNomeDestino();
        if (nomeDestino != null && !nomeDestino.isEmpty()) {
            destino = new File(nomeDestino);
        }

        atualizarArquivos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campoOrigem = new javax.swing.JTextField();
        botaoPesquisarOrigem = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoLimSuperior = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoLimEsquerdo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoLimInferior = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoLimDireito = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spinnerMinZoom = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        spinnerMaxZoom = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        campoDestino = new javax.swing.JTextField();
        botaoPesquisarDestino = new javax.swing.JButton();
        botaoAutoZoom = new javax.swing.JButton();
        botaoProcessar = new javax.swing.JButton();
        botaoSair = new javax.swing.JButton();
        botaoLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Visual Tile");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Arquivo de Origem:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 4);
        jPanel1.add(jLabel1, gridBagConstraints);

        campoOrigem.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(campoOrigem, gridBagConstraints);

        botaoPesquisarOrigem.setText("Pesquisar");
        botaoPesquisarOrigem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarOrigemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(botaoPesquisarOrigem, gridBagConstraints);

        jLabel2.setText("Limite Superior:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 4);
        jPanel1.add(jLabel2, gridBagConstraints);

        campoLimSuperior.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(campoLimSuperior, gridBagConstraints);

        jLabel3.setText("Limite Esquerdo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 4);
        jPanel1.add(jLabel3, gridBagConstraints);

        campoLimEsquerdo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(campoLimEsquerdo, gridBagConstraints);

        jLabel4.setText("Limite Inferior:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 4);
        jPanel1.add(jLabel4, gridBagConstraints);

        campoLimInferior.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(campoLimInferior, gridBagConstraints);

        jLabel5.setText("Limite Direito:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 4);
        jPanel1.add(jLabel5, gridBagConstraints);

        campoLimDireito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(campoLimDireito, gridBagConstraints);

        jLabel6.setText("Zoom Mínimo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 4);
        jPanel1.add(jLabel6, gridBagConstraints);

        spinnerMinZoom.setModel(new javax.swing.SpinnerNumberModel(0, 0, 25, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(spinnerMinZoom, gridBagConstraints);

        jLabel7.setText("Zoom Máximo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 4);
        jPanel1.add(jLabel7, gridBagConstraints);

        spinnerMaxZoom.setModel(new javax.swing.SpinnerNumberModel(25, 0, 25, 1));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(spinnerMaxZoom, gridBagConstraints);

        jLabel8.setText("Pasta de Destino:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 4);
        jPanel1.add(jLabel8, gridBagConstraints);

        campoDestino.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(campoDestino, gridBagConstraints);

        botaoPesquisarDestino.setText("Pesquisar");
        botaoPesquisarDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPesquisarDestinoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 0);
        jPanel1.add(botaoPesquisarDestino, gridBagConstraints);

        botaoAutoZoom.setText("Auto Zoom");
        botaoAutoZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAutoZoomActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel1.add(botaoAutoZoom, gridBagConstraints);

        botaoProcessar.setText("Processar");
        botaoProcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoProcessarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        jPanel1.add(botaoProcessar, gridBagConstraints);

        botaoSair.setText("Sair");
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        jPanel1.add(botaoSair, gridBagConstraints);

        botaoLimpar.setText("Limpar");
        botaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLimparActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        jPanel1.add(botaoLimpar, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 13)); // NOI18N
        jTextArea1.setRows(10);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);
        getContentPane().add(barra, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(731, 493));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        sair();
    }//GEN-LAST:event_formWindowClosing

    private void botaoPesquisarOrigemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarOrigemActionPerformed
        pesquisarOrigem();
    }//GEN-LAST:event_botaoPesquisarOrigemActionPerformed

    private void botaoPesquisarDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPesquisarDestinoActionPerformed
        pesquisarDestino();
    }//GEN-LAST:event_botaoPesquisarDestinoActionPerformed

    private void botaoAutoZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAutoZoomActionPerformed
        autoZoom();
    }//GEN-LAST:event_botaoAutoZoomActionPerformed

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        sair();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLimparActionPerformed
        limpar();
    }//GEN-LAST:event_botaoLimparActionPerformed

    private void botaoProcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoProcessarActionPerformed
        processar();
    }//GEN-LAST:event_botaoProcessarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private final javax.swing.JProgressBar barra = new javax.swing.JProgressBar();
    private javax.swing.JButton botaoAutoZoom;
    private javax.swing.JButton botaoLimpar;
    private javax.swing.JButton botaoPesquisarDestino;
    private javax.swing.JButton botaoPesquisarOrigem;
    private javax.swing.JButton botaoProcessar;
    private javax.swing.JButton botaoSair;
    private javax.swing.JTextField campoDestino;
    private javax.swing.JTextField campoLimDireito;
    private javax.swing.JTextField campoLimEsquerdo;
    private javax.swing.JTextField campoLimInferior;
    private javax.swing.JTextField campoLimSuperior;
    private javax.swing.JTextField campoOrigem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JSpinner spinnerMaxZoom;
    private javax.swing.JSpinner spinnerMinZoom;
    // End of variables declaration//GEN-END:variables

    private void limpar() {
        jTextArea1.setText(null);
    }

    /**
     *
     */
    private void sair() {

        recuperarDados(false);

        Config.save();

        System.exit(0);
    }

    /**
     *
     * @param mostraErro
     * @return
     */
    private boolean recuperarDados(boolean mostraErro) {

        if (mostraErro) {
            if (origem != null) {
                if (!origem.exists()) {
                    erro("O Arquivo de Origem não existe.");
                    return false;
                }
                if (!origem.isFile()) {
                    erro("O Arquivo de Origem não é um arquivo.");
                    return false;
                }
            } else {
                erro("O campo Arquivo de Origem deve ser informado.");
                return false;
            }

            try {
                Double.parseDouble(campoLimSuperior.getText().trim());
            } catch (Exception ex) {
                erro("O campo Limite Superior deve ser uma coordenada no formato grau decimal.");
                return false;
            }

            try {
                Double.parseDouble(campoLimEsquerdo.getText().trim());
            } catch (Exception ex) {
                erro("O campo Limite Esquerdo deve ser uma coordenada no formato grau decimal.");
                return false;
            }

            try {
                Double.parseDouble(campoLimInferior.getText().trim());
            } catch (Exception ex) {
                erro("O campo Limite Inferior deve ser uma coordenada no formato grau decimal.");
                return false;
            }

            try {
                Double.parseDouble(campoLimDireito.getText().trim());
            } catch (Exception ex) {
                erro("O campo Limite Direito deve ser uma coordenada no formato grau decimal.");
                return false;
            }

            int minZoom = (int) spinnerMinZoom.getValue();

            int maxZoom = (int) spinnerMaxZoom.getValue();

            if (minZoom > maxZoom) {
                erro("O Zoom Mínimo é maior do que o Zoom Máximo.");
                return false;
            }

            if (destino != null) {
                if (!destino.exists()) {
                    int ret = JOptionPane.showConfirmDialog(this,
                            "A Pasta de Destino não existe. Deseja cria-la?",
                            "Dúvida", JOptionPane.YES_NO_OPTION);

                    if (ret == JOptionPane.YES_OPTION) {
                        if (!destino.mkdirs()) {
                            erro("Não foi possível criar a Pasta de Destino.");
                            return false;
                        }
                    } else {
                        erro("A Pasta de Destino não foi criada.");
                        return false;
                    }

                }
                if (!destino.isDirectory()) {
                    erro("A Pasta de Destino não é uma pasta.");
                    return false;
                }
            } else {
                erro("O campo Pasta de Destino deve ser informado.");
                return false;
            }

        }

        /**
         *
         *
         *
         *
         */
        boolean retvar = true;

        Config config = Config.getInstance();

        if (origem != null) {
            config.setNomeOrigem(origem.getAbsolutePath());
        } else {
            config.setNomeOrigem("");
            retvar = false;
        }

        try {
            config.setLimSuperior(Double.parseDouble(campoLimSuperior.getText().trim()));
        } catch (Exception ex) {
            config.setLimSuperior(0.0);
            retvar = false;
        }

        try {
            config.setLimEsquerdo(Double.parseDouble(campoLimEsquerdo.getText().trim()));
        } catch (Exception ex) {
            config.setLimEsquerdo(0.0);
            retvar = false;
        }

        try {
            config.setLimInferior(Double.parseDouble(campoLimInferior.getText().trim()));
        } catch (Exception ex) {
            config.setLimInferior(0.0);
            retvar = false;
        }

        try {
            config.setLimDireito(Double.parseDouble(campoLimDireito.getText().trim()));
        } catch (Exception ex) {
            config.setLimDireito(0.0);
            retvar = false;
        }

        config.setMinZoom((int) spinnerMinZoom.getValue());

        config.setMaxZoom((int) spinnerMaxZoom.getValue());

        if (config.getMinZoom() > config.getMaxZoom()) {
            retvar = false;
        }

        if (destino != null) {
            config.setNomeDestino(destino.getAbsolutePath());
        } else {
            config.setNomeDestino("");
            retvar = false;
        }

        return retvar;
    }

    /**
     *
     */
    private void atualizarArquivos() {
        if (origem != null) {
            campoOrigem.setText(origem.getAbsolutePath());
        }

        if (destino != null) {
            campoDestino.setText(destino.getAbsolutePath());
        }
    }

    /**
     *
     */
    private void pesquisarOrigem() {
        JFileChooser fc = new JFileChooser(origem);
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int ret = fc.showOpenDialog(this);
        if (ret == JFileChooser.APPROVE_OPTION) {
            origem = fc.getSelectedFile();
            atualizarArquivos();
        }
    }

    /**
     *
     */
    private void pesquisarDestino() {
        JFileChooser fc = new JFileChooser(destino);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int ret = fc.showSaveDialog(this);
        if (ret == JFileChooser.APPROVE_OPTION) {
            destino = fc.getSelectedFile();
            atualizarArquivos();
        }
    }

    /**
     *
     * @param msg
     */
    private void erro(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    /**
     *
     */
    private void autoZoom() {
        if (recuperarDados(true)) {
            new Thread(() -> {
                iniciar();
                try {
                    Tile.autoZoom(this);

                    Config config = Config.getInstance();

                    spinnerMinZoom.setValue(config.getMinZoom());
                    spinnerMaxZoom.setValue(config.getMaxZoom());

                    System.out.println("");
                    System.out.println("Operação concluída com sucesso!");
                } catch (Exception ex) {
                    System.out.println("");
                    System.out.println("Não foi possível realizar a operação!");
                    System.out.println(ex.getMessage());
                }
                System.out.println("");
                System.out.println("");
                finalizar();
            }).start();
        }
    }

    /**
     *
     */
    private void processar() {
        if (recuperarDados(true)) {
            new Thread(() -> {
                iniciar();
                try {
                    Tile.processar(this);

                    System.out.println("");
                    System.out.println("Operação concluída com sucesso!");
                } catch (Exception ex) {
                    System.out.println("");
                    System.out.println("Não foi possível realizar a operação!");
                    System.out.println(ex.getMessage());
                }
                System.out.println("");
                System.out.println("");
                finalizar();
            }).start();
        }
    }

    /**
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    @Override
    public void iniciar() {
        barra.setMinimum(0);
        barra.setValue(0);
        barra.setMaximum(100);
    }

    @Override
    public void setMaximo(int max) {
        barra.setMaximum(max);
    }

    @Override
    public void incrementar() {
        barra.setValue(barra.getValue() + 1);
    }

    @Override
    public void finalizar() {
        new Thread(() -> {
            barra.setValue(barra.getMaximum());
            try {
                Thread.sleep(2000);
            } catch (Exception ex) {

            }
            barra.setValue(0);
        }).start();
    }
}
