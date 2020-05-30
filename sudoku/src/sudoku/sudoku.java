package sudoku;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class sudoku extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField[][] txt= new TextField[6][6];
        primaryStage.setTitle("Sudoku 6! ");
        Button button = new Button("Check Correctness");
        button.setMinHeight(35);
        button.setMinWidth(175);
        GridPane root= new GridPane();
        Label lbl= new Label();
        lbl.setMinHeight(35);
        lbl.setMinWidth(150);
        for (int i = 0; i < 6 ;i++)
        {
            for (int j = 0; j < 6; j++) 
            {
                txt[i][j] = new TextField();
                root.add(txt[i][j], i, j);
            }
         }
        button.setOnAction((ActionEvent e)->
        {
            boolean condition = true;
            for(int i = 0; i<6; i++)
            {
                for(int j=0; j<6; j++)
                {
                    for(int a = 0; a<6; a++)
                    {
                        for(int c = 0; c<6; c++)
                        {
                            if(txt[a][c].getText().isEmpty() || txt[a][c].getText() == null )
                            {
                                lbl.setText("Incomplete Solution");
                                condition = false;
                                break;
                            }
                        }
                    }
                    for(int a = 0; a<6; a++)
                    {
                        for(int c = 0; c<6; c++)
                        {
                            if(Integer.parseInt(txt[i][j].getText()) > 6 || Integer.parseInt(txt[i][j].getText()) < 1 )
                            {
                                lbl.setText("Enter a number between 1 and 6 only");
                                condition = false;
                                break;
                            }                            
                        }  
                    } 

                    for(int k=0; k<6; k++)
                    {
                        if(Integer.parseInt(txt[i][k].getText()) == Integer.parseInt(txt[i][j].getText()) && k != j)
                        {
                            lbl.setText("Incorrect Answer");
                            condition = false;
                            break;
                        }
                        if(Integer.parseInt(txt[k][j].getText()) == Integer.parseInt(txt[i][j].getText()) && k != i)
                        {
                            lbl.setText("Incorrect Answer");
                            condition = false;
                            break;
                        }
                    }
                }
                if(condition == false)
                {
                       break;
                }       
            }
            if(condition == true)
            {
                lbl.setText("Correct Solution");
            }
        });
        Scene scene = new Scene(root,925,300);
        root.add(lbl, 0, 10);
        root.add(button,0, 15);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}