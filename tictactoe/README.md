# TicTacToe using Model-View-Controller paradigm
TicTacToe.java is a basic Java implementation of the well-known Tic Tac Toe game using MVC approach.

### Design Choice - MVC Approach
#### Model (M) - Contains the current state of the game and logic for checking win or tie
#### View (V) - Contains the components of the GUI that the user can use to play the game
#### Controller (C) - Acts as an interface between the View and the Model

### Game Flow

1. The view displays the GUI including adding buttons for control, and the flow of the game begins here. 

2. Which is numberedThe Driver class (TicTacToe.java) instantiates the `Model`, `View` and `Controller`classes. 
         
3. The `Adapter` then monitors the button for an event, and defines the `actionPerformed` for the `ActionListeners`. 
         
4. The control is then transferred from the `Adapter` class to the `Controller` class. 
		 
5. The `Controller` notifies the `Model` that a move has been made on the (x,y) coordinate of the game board. 
		 
6. The `Model` then updates its board state and accordingly updates the `View`. 
		 
7. After every move, the `Model` class also checks if a winning condition has been achieved by a player or whether the game has tied and notifies the `View` with an appropriate message. 
		 
8. The `Reset` button allows the user to clear the baord and start a new game.

### Classes and Functionality

#### TicTacToe class
This is the main (Driver) class for the game. It creates instances of Model, View and Controller classes and aggregates them.

#### Model Class
The model class is stores the current state of the game as well as the winning logic. Every time there is a change in the state of the game, the Model is resposible for updating the View accordingly.

Members:
```java
private View v
private int playerId
private int movesCount
private char[][] board
private String message
```

Methods (apart from getters and setters:
```java
public Model()
public void registerView(View v)
public void PlayMove(int x, int y)
public boolean isWinner(int x, int y)
public void ResetModel()
```

#### View Class
The View class is responsible for holding the elements that make up the GUI of the game and displaying the state of the game on the GUI as and when it is informed by the Model.

Members:
```java
private Adapter adapter
private JFrame gui
private JButton[][] blocks
private JButton reset
private JTextArea playerturn
```

Methods:
```java
public View() 
public void setActionListener(Controller c)
public void initialize ()
public boolean isReset(ActionEvent e) 
public ArrayList<Integer> getPosition(ActionEvent e) 
public void update(int row, int column, char symbol, String message)
public void isWinner(int row, int column, char symbol, String message)
public void resetGame()
```

#### Controller Class
The Controller class acts as an interface between the model and the view and is responsible for requesting the model to update its state whenever there is an event on a button on the game grid.

Members:
```java
private Model m
```

Methods:
```java
public void setModel(Model m) 
public void setRequest(ArrayList<Integer> position) 
public void setRequest()
```

#### Adapter Class implements ActionListener
The Adapter class acts as an interface between view and Controller to facilitate decoupling. It listens for actions on the buttons pn the game board and invokes the Controller to take the appropriate action.

Members:
```java
private Controller c
private View v
```

Methods:
```java
public Adapter(Controller c, View v)
public void actionPerformed(ActionEvent e)
```

### Steps to build and test the code from command line:

1. Install [Apache Ant](https://ant.apache.org/bindownload.cgi)

2. Navigate to the directory that contains the `build.xml` build file and run the command: `ant`.
   After this, the compiled java classes will be in the `bin` directory.

3. Run the command `ant test` to run all unit tests.

### Steps to run the code from command line:

1. After building and running tests as described above, run:
   `java -cp bin TicTacToe`

### Cleaning up from command line:

1. Run `ant clean` to clean the project i.e., delete all the generated files.