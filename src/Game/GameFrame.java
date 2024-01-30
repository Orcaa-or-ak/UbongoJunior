
package Game;

import java.awt.Color;
import java.util.Random;
import Block.*;
import Board.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.plaf.ColorUIResource;


public class GameFrame extends javax.swing.JFrame implements TimeFinishListener{
    private List<Integer> availableBoards2 = new ArrayList<>();
    private List<Integer> availableBoards3 = new ArrayList<>();
    private List<Player> players;
    private int currentPlayerIndex = 0;
    private Player currentPlayer;
    private CountdownTimer timer;
    private Timer checkTimer;
    private int mode = 0;
    private int boardCount =  0;
    private GameBoard board;
    private GameBlock block1;
    private GameBlock block2;
    private GameBlock block3;

    public GameFrame(int numberOfPlayers) {
        initComponents();
        setLocationRelativeTo(null);
        initializeBoardLists();
        // Initialize players
        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player());
            switch(i){
                case 0 -> Score0.setText("Player 1 : 0");
                case 1 -> Score1.setText("Player 2 : 0");
                case 2 -> Score2.setText("Player 3 : 0");
                case 3 -> Score3.setText("Player 4 : 0");
            }
        }        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playArea = new javax.swing.JPanel();
        NotifySeleceModeLabel = new javax.swing.JLabel();
        TimerPanel = new javax.swing.JPanel();
        ModePanel = new javax.swing.JPanel();
        TwoPiecesMode = new javax.swing.JButton();
        ThreePiecesMode = new javax.swing.JButton();
        ScorePanel = new javax.swing.JPanel();
        Score0 = new javax.swing.JLabel();
        Score1 = new javax.swing.JLabel();
        Score2 = new javax.swing.JLabel();
        Score3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 204));
        setResizable(false);

        playArea.setBackground(new java.awt.Color(153, 0, 0));
        playArea.setMaximumSize(new java.awt.Dimension(1000, 1000));
        playArea.setMinimumSize(new java.awt.Dimension(250, 250));
        playArea.setPreferredSize(new java.awt.Dimension(500, 500));
        playArea.setLayout(new java.awt.BorderLayout());

        NotifySeleceModeLabel.setFont(new java.awt.Font("Ravie", 0, 24)); // NOI18N
        NotifySeleceModeLabel.setForeground(new java.awt.Color(255, 255, 255));
        NotifySeleceModeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NotifySeleceModeLabel.setText("Please select a mode");
        playArea.add(NotifySeleceModeLabel, java.awt.BorderLayout.CENTER);

        TimerPanel.setBackground(new java.awt.Color(153, 0, 0));
        TimerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Timer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ravie", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N
        TimerPanel.setLayout(new java.awt.BorderLayout());

        ModePanel.setBackground(new java.awt.Color(153, 0, 0));
        ModePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mode", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ravie", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N

        TwoPiecesMode.setText("2 Blocks");
        TwoPiecesMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwoPiecesModeActionPerformed(evt);
            }
        });

        ThreePiecesMode.setText("3 Blocks");
        ThreePiecesMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThreePiecesModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ModePanelLayout = new javax.swing.GroupLayout(ModePanel);
        ModePanel.setLayout(ModePanelLayout);
        ModePanelLayout.setHorizontalGroup(
            ModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ThreePiecesMode, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(TwoPiecesMode, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addContainerGap())
        );
        ModePanelLayout.setVerticalGroup(
            ModePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ModePanelLayout.createSequentialGroup()
                .addComponent(TwoPiecesMode, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ThreePiecesMode, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ScorePanel.setBackground(new java.awt.Color(153, 0, 0));
        ScorePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Score", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Ravie", 0, 36), new java.awt.Color(255, 255, 255))); // NOI18N

        Score0.setFont(new java.awt.Font("Ravie", 0, 20)); // NOI18N
        Score0.setForeground(new java.awt.Color(255, 255, 255));
        Score0.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Score0.setText("Player 1 : ");

        Score1.setFont(new java.awt.Font("Ravie", 0, 20)); // NOI18N
        Score1.setForeground(new java.awt.Color(255, 255, 255));
        Score1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Score1.setText("Player 2 :");

        Score2.setFont(new java.awt.Font("Ravie", 0, 20)); // NOI18N
        Score2.setForeground(new java.awt.Color(255, 255, 255));
        Score2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Score2.setText("Player 3 :");

        Score3.setFont(new java.awt.Font("Ravie", 0, 20)); // NOI18N
        Score3.setForeground(new java.awt.Color(255, 255, 255));
        Score3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Score3.setText("Player 4 :");

        javax.swing.GroupLayout ScorePanelLayout = new javax.swing.GroupLayout(ScorePanel);
        ScorePanel.setLayout(ScorePanelLayout);
        ScorePanelLayout.setHorizontalGroup(
            ScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Score0, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(Score1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(Score2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                    .addComponent(Score3, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                .addContainerGap())
        );
        ScorePanelLayout.setVerticalGroup(
            ScorePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScorePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Score0, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Score1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Score2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Score3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playArea, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ModePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ScorePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TimerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ModePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScorePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TwoPiecesModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwoPiecesModeActionPerformed
        // TODO add your handling code here:
        startGame(2);
        TwoPiecesMode.setEnabled(false);
        ThreePiecesMode.setEnabled(false);
        mode = 2;
        

    }//GEN-LAST:event_TwoPiecesModeActionPerformed

    private void ThreePiecesModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThreePiecesModeActionPerformed
        // TODO add your handling code here:
        startGame(3);
        TwoPiecesMode.setEnabled(false);
        ThreePiecesMode.setEnabled(false);
        mode = 3;   
    }//GEN-LAST:event_ThreePiecesModeActionPerformed

    
    
    public void getRandomBoard2(){
        if (availableBoards2.isEmpty()) {
            initializeBoardLists(); // Reinitialize the list if empty
        }
        Random random = new Random();
        int index = random.nextInt(availableBoards2.size());
        int roll = availableBoards2.get(index);
        if (availableBoards2.isEmpty()) {
            return; // If list is empty, don't proceed.
        }
        availableBoards2.remove(index);
        
        switch (roll){
            case 1 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_1);
                block1 = new GameBlock(BlockLayout.MONKEY_BLOCK, Color.yellow,BlockLayout.MonkeyBound);
                block2 = new GameBlock(BlockLayout.GIRAFFE_BLOCK, Color.red,BlockLayout.GiraffeBound);
                
            }
                
            case 2 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_2);
                block1 = new GameBlock(BlockLayout.CROCODILE_BLOCK, Color.yellow,BlockLayout.CrocodileBound);
                block2 = new GameBlock(BlockLayout.LION_BLOCK, Color.red,BlockLayout.LionBound);
               
            }
                
            case 3 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_3);
                block1 = new GameBlock(BlockLayout.TUCAN_BLOCK, Color.yellow,BlockLayout.TucanBound);
                block2 = new GameBlock(BlockLayout.OSTRICH_BLOCK, Color.red,BlockLayout.OstrichBound);
                
            }
            
            case 4 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_4);
                block1 = new GameBlock(BlockLayout.SNAKE_BLOCK, Color.yellow,BlockLayout.SnakeBound);
                block2 = new GameBlock(BlockLayout.GIRAFFE_BLOCK, Color.red,BlockLayout.GiraffeBound);
                
            }
            case 5 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_5);
                block1 = new GameBlock(BlockLayout.SNAKE_BLOCK, Color.yellow,BlockLayout.SnakeBound);
                block2 = new GameBlock(BlockLayout.MONKEY_BLOCK, Color.red,BlockLayout.MonkeyBound);
                
            }
            
            case 6 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_6);
                block1 = new GameBlock(BlockLayout.TUCAN_BLOCK, Color.yellow,BlockLayout.TucanBound);
                block2 = new GameBlock(BlockLayout.GROUNDHOG_BLOCK, Color.red,BlockLayout.GroundHogBound);
                board.addGameBlock(block1);
                board.addGameBlock(block2);
            }
            case 7 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_7);
                block1 = new GameBlock(BlockLayout.CROCODILE_BLOCK, Color.yellow,BlockLayout.CrocodileBound);
                block2 = new GameBlock(BlockLayout.GECKO_BLOCK, Color.red,BlockLayout.GeckoBound);
            }
            case 8 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_8);
                block1 = new GameBlock(BlockLayout.ZEBRA_BLOCK, Color.yellow,BlockLayout.ZebraBound);
                block2 = new GameBlock(BlockLayout.GECKO_BLOCK, Color.red,BlockLayout.GeckoBound);
            }
            case 9 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_9);
                block1 = new GameBlock(BlockLayout.ZEBRA_BLOCK, Color.yellow,BlockLayout.ZebraBound);
                block2 = new GameBlock(BlockLayout.OSTRICH_BLOCK, Color.red,BlockLayout.OstrichBound);
            }
                
            case 10 -> {
                board = new GameBoard(BoardLayout2.BOARD_SHAPE_10);
                block1 = new GameBlock(BlockLayout.GECKO_BLOCK, Color.yellow,BlockLayout.GeckoBound);
                block2 = new GameBlock(BlockLayout.LION_BLOCK, Color.red,BlockLayout.LionBound);
            }
                
        }
        
        
    }
    
    private void getRandomBoard3(){
        if (availableBoards3.isEmpty()) {
            initializeBoardLists(); // Reinitialize the list if empty
        }
        Random random = new Random();
        int index = random.nextInt(availableBoards3.size());
        int roll = availableBoards3.get(index);
        if (availableBoards3.isEmpty()) {
            return; // If list is empty, don't proceed.
        }
        availableBoards3.remove(index);
        
        switch (roll){
            case 1 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_1);
                block1 = new GameBlock(BlockLayout.GROUNDHOG_BLOCK, Color.yellow,BlockLayout.GroundHogBound);
                block2 = new GameBlock(BlockLayout.GECKO_BLOCK, Color.red,BlockLayout.GeckoBound);
                block3 = new GameBlock(BlockLayout.OSTRICH_BLOCK, Color.blue,BlockLayout.OstrichBound);
            }
                
            case 2 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_2);
                block1 = new GameBlock(BlockLayout.OSTRICH_BLOCK, Color.yellow,BlockLayout.OstrichBound);
                block2 = new GameBlock(BlockLayout.LION_BLOCK, Color.red,BlockLayout.LionBound);
                block3 = new GameBlock(BlockLayout.SNAKE_BLOCK, Color.blue,BlockLayout.SnakeBound);
            }

            case 3 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_3);
                block1 = new GameBlock(BlockLayout.GECKO_BLOCK, Color.yellow,BlockLayout.GeckoBound);
                block2 = new GameBlock(BlockLayout.LION_BLOCK, Color.red,BlockLayout.LionBound);
                block3 = new GameBlock(BlockLayout.GROUNDHOG_BLOCK, Color.blue,BlockLayout.GroundHogBound);
            }
            
            case 4 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_4);
                block1 = new GameBlock(BlockLayout.TUCAN_BLOCK, Color.yellow,BlockLayout.TucanBound);
                block2 = new GameBlock(BlockLayout.CHEETAH_BLOCK, Color.red,BlockLayout.CheetahBound);
                block3 = new GameBlock(BlockLayout.CROCODILE_BLOCK, Color.blue,BlockLayout.CrocodileBound);
            }
            
            case 5 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_5);
                block1 = new GameBlock(BlockLayout.TUCAN_BLOCK, Color.yellow,BlockLayout.TucanBound);
                block2 = new GameBlock(BlockLayout.CHEETAH_BLOCK, Color.red,BlockLayout.CheetahBound);
                block3 = new GameBlock(BlockLayout.ZEBRA_BLOCK, Color.blue,BlockLayout.ZebraBound);
            }
            
            case 6 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_6);
                block1 = new GameBlock(BlockLayout.GECKO_BLOCK, Color.yellow,BlockLayout.GeckoBound);
                block2 = new GameBlock(BlockLayout.TUCAN_BLOCK, Color.red,BlockLayout.TucanBound);
                block3 = new GameBlock(BlockLayout.GROUNDHOG_BLOCK, Color.blue,BlockLayout.GroundHogBound);
            }
            
            case 7 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_7);
                block1 = new GameBlock(BlockLayout.CROCODILE_BLOCK, Color.yellow,BlockLayout.CrocodileBound);
                block2 = new GameBlock(BlockLayout.GECKO_BLOCK, Color.red,BlockLayout.GeckoBound);
                block3 = new GameBlock(BlockLayout.GROUNDHOG_BLOCK, Color.blue,BlockLayout.GroundHogBound);
            }
            
            case 8 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_8);
                block1 = new GameBlock(BlockLayout.SNAKE_BLOCK, Color.yellow,BlockLayout.SnakeBound);
                block2 = new GameBlock(BlockLayout.MONKEY_BLOCK, Color.red,BlockLayout.MonkeyBound);
                block3 = new GameBlock(BlockLayout.CHEETAH_BLOCK, Color.blue,BlockLayout.CheetahBound);
            }
            
            case 9 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_9);
                block1 = new GameBlock(BlockLayout.OSTRICH_BLOCK, Color.yellow,BlockLayout.OstrichBound);
                block2 = new GameBlock(BlockLayout.TUCAN_BLOCK, Color.red,BlockLayout.TucanBound);
                block3 = new GameBlock(BlockLayout.CHEETAH_BLOCK, Color.blue,BlockLayout.CheetahBound);
            }
            
            case 10 -> {
                board = new GameBoard(BoardLayout3.BOARD_SHAPE_10);
                block1 = new GameBlock(BlockLayout.SNAKE_BLOCK, Color.yellow,BlockLayout.SnakeBound);
                block2 = new GameBlock(BlockLayout.CHEETAH_BLOCK, Color.red,BlockLayout.CheetahBound);
                block3 = new GameBlock(BlockLayout.TUCAN_BLOCK, Color.blue,BlockLayout.TucanBound);
            }
        }
        
    }    
    
    
    @Override
    public void onTimerFinish() {
        if (!isSolved()) {
            displayGameOver();
            new Thread(() -> {
                   try {
                       Thread.sleep(2000); // Wait for 2 seconds
                       SwingUtilities.invokeLater(() -> switchToNextPlayer());
                   } catch (InterruptedException ex) {
                       ex.printStackTrace();
                   }
               }).start();
        }
    }
    
    public boolean isSolved(){
       return (board.isPuzzleSolved());
    }
    
    public void displayWellDone(){
        if (checkTimer != null) {
           checkTimer.stop();// Stop the checkTimer
           checkTimer = null;
        }
        if (timer != null){
            timer.stopTime();
        }
        playArea.removeAll(); // Clear the play area
        JLabel WellDoneLabel = new JLabel("Well Done!", SwingConstants.CENTER);
        WellDoneLabel.setFont(new Font("Ravie", Font.BOLD, 24));
        WellDoneLabel.setForeground(Color.white); // Set text color
        playArea.add(WellDoneLabel);
        playArea.revalidate(); // Refresh the panel
        playArea.repaint(); // Redraw the panel
    }
    
    public void displayGameOver() {
        if (checkTimer != null) {
           checkTimer.stop();// Stop the checkTimer
           checkTimer = null;
        }
        if (timer != null){
            timer.stopTime();
        }
        playArea.removeAll(); // Clear the play area
        JLabel gameOverLabel = new JLabel("Game Over", SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Ravie", Font.BOLD, 24));
        gameOverLabel.setForeground(Color.RED); // Set text color
        playArea.add(gameOverLabel);
        playArea.revalidate(); // Refresh the panel
        playArea.repaint(); // Redraw the panel
    }
    
    public void startGame(int mode) {
        this.mode = mode;
        loadNewBoard(mode);
        setupTimer();
        setupPuzzleCheckTimer();
        block1.setMouseInputEnabled(true);
        block2.setMouseInputEnabled(true);
        if (mode == 3) {
            block3.setMouseInputEnabled(true);
        }
            
    }
    
    private void initializeBoardLists(){
        availableBoards2.clear();
        availableBoards3.clear();
        for (int i = 1; i <= 10; i++) {
            availableBoards2.add(i);
            availableBoards3.add(i);
        }
    }
    
    public void checkPuzzleCompletion(){
        if(isSolved()){
           boardCount++;
           if(boardCount < 5){        
                loadNewBoard(mode);
                updateScoreForCurrentPlayer();
                block1.setMouseInputEnabled(true);
                block2.setMouseInputEnabled(true);
                if (mode == 3) {
                   block3.setMouseInputEnabled(true);
                }
           }
           else {
               displayWellDone();
               updateScoreForCurrentPlayer();
               new Thread(() -> {
                   try {
                       Thread.sleep(2000); // Wait for 2 seconds
                       SwingUtilities.invokeLater(() -> switchToNextPlayer());
                   } catch (InterruptedException ex) {
                       ex.printStackTrace();
                   }
               }).start();
           }
        } 
    }
    
    public void loadNewBoard(int mode) {
        playArea.removeAll();
        if (mode == 2) {
            getRandomBoard2();
            //block1.setLocation(50,350);
            //block2.setLocation(300,350);
            board.setBackground(new Color(13,150,41));
        } else if (mode == 3) {
            getRandomBoard3();
            //block1.setLocation(50,350);
            //block2.setLocation(300,350);      
            //block3.setLocation(200,500);
            board.setBackground(new Color(225,198,0));
        }

        // Common logic for adding blocks to the board
        board.addGameBlock(block1);
        board.addGameBlock(block2);
        
        if (mode == 3) {
            board.addGameBlock(block3); // Add the third block only for 3-block mode
        }
        

        playArea.add(board);
        playArea.revalidate();
        playArea.repaint();

        // Restart the puzzle check timer
        if (checkTimer != null) {
            checkTimer.restart();
        }
    }
    
    
    public void resetAndStartTimer() {
        if (timer != null) {
            timer.resetAndStart();
            System.out.println("time reset");
        }
    }
    
    private void setupTimer() {
        // Initialize the timer
        timer = new CountdownTimer();
        timer.setFinishListener(this);
        TimerPanel.add(timer, BorderLayout.CENTER); // Add timer to the TimerPanel
        TimerPanel.revalidate();
        TimerPanel.repaint();
    }
    
    private void setupPuzzleCheckTimer() {
        checkTimer = new Timer(2000, e -> checkPuzzleCompletion());
        checkTimer.start();
    }
    
    
    public void updateScoreForCurrentPlayer() {
        if (!players.isEmpty() && currentPlayerIndex < players.size()) {
            currentPlayer = players.get(currentPlayerIndex);
            currentPlayer.addScore(100);
        }
        switch (currentPlayerIndex) {
        case 0 -> Score0.setText("Player 1 :" + String.valueOf(currentPlayer.getScore()));
        case 1 -> Score1.setText("Player 2 :" + String.valueOf(currentPlayer.getScore()));
        case 2 -> Score2.setText("Player 3 :" + String.valueOf(currentPlayer.getScore()));
        case 3 -> Score3.setText("Player 4 :" + String.valueOf(currentPlayer.getScore()));
    }
        // Handle invalid player index if necessary
                
    }
    
    public void switchToNextPlayer() {
        currentPlayerIndex++;
        System.err.println("player:" + currentPlayerIndex);
        System.out.println("Size: " + players.size());
        if (currentPlayerIndex < players.size()) {
            TimerPanel.removeAll();
            resetAndStartTimer();
            boardCount = 0; 
            startGame(mode);
            
        } else {
            // All players have played, handle end of game

        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ModePanel;
    private javax.swing.JLabel NotifySeleceModeLabel;
    private javax.swing.JLabel Score0;
    private javax.swing.JLabel Score1;
    private javax.swing.JLabel Score2;
    private javax.swing.JLabel Score3;
    private javax.swing.JPanel ScorePanel;
    private javax.swing.JButton ThreePiecesMode;
    private javax.swing.JPanel TimerPanel;
    private javax.swing.JButton TwoPiecesMode;
    private javax.swing.JPanel playArea;
    // End of variables declaration//GEN-END:variables
}
