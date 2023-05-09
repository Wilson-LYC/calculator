package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import service.CalculationService;
import service.MainService;

public class MainViewController {
    @FXML
    public Label firstInput;
    @FXML
    public Label secondInput;

    boolean flagOperation=true;
    boolean flagZero=true;
    CalculationService cService=new CalculationService();
    MainService mainService =new MainService(cService,this);
    /**
     * 按钮外观
     */
    String btStyleDefault="-fx-background-color:#fcfcfc;-fx-border-color:#cccccc";
    String btStyleMouseEnter="-fx-background-color:#eaeaea;-fx-border-color:#cccccc";
    String btStyleMousePress="-fx-background-color:rgba(208,208,208,0.76);-fx-border-color:#cccccc";

    /**
     * 监听键盘
     */
    @FXML
    private void keyPressed(KeyEvent key){
        if(key.getCode()==KeyCode.NUMPAD1 || key.getCode()==KeyCode.DIGIT1){
            this.bt1OnMousePress();
            this.bt1OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD2 || key.getCode()==KeyCode.DIGIT2){
            this.bt2OnMousePress();
            this.bt2OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD3 || key.getCode()==KeyCode.DIGIT3){
            this.bt3OnMousePress();
            this.bt3OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD4 || key.getCode()==KeyCode.DIGIT4){
            this.bt4OnMousePress();
            this.bt4OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD5 || key.getCode()==KeyCode.DIGIT5){
            this.bt5OnMousePress();
            this.bt5OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD6 || key.getCode()==KeyCode.DIGIT6){
            this.bt6OnMousePress();
            this.bt6OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD7 || key.getCode()==KeyCode.DIGIT7){
            this.bt7OnMousePress();
            this.bt7OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD8 || key.getCode()==KeyCode.DIGIT8){
            this.bt8OnMousePress();
            this.bt8OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD9 || key.getCode()==KeyCode.DIGIT9){
            this.bt9OnMousePress();
            this.bt9OnMouseClick();
        }
        if(key.getCode()==KeyCode.NUMPAD0 || key.getCode()==KeyCode.DIGIT0){
            this.bt0OnMousePress();
            this.bt0OnMouseClick();
        }
        if(key.getCode()==KeyCode.DECIMAL){
            this.btPointOnMousePress();
            this.btPointOnMouseClick();
        }
        if(key.getCode()==KeyCode.BACK_SPACE){
            this.btBackSpaceOnMousePress();
            this.btBackSpaceOnMouseClick();
        }
        if(key.getCode()==KeyCode.ADD){
            this.btAddOnMousePress();
            this.btAddOnMouseClick();
        }
        if(key.getCode()==KeyCode.MULTIPLY){
            this.btMultiplyOnMousePress();
            this.btMultiplyOnMouseClick();
        }
        if(key.getCode()==KeyCode.DELETE){
            this.btCEOnMousePress();
            this.btCEOnMouseClick();
        }
        if(key.getCode()==KeyCode.ENTER || key.getCode()==KeyCode.EQUALS){
            this.btEqualOnMouseEnter();
            this.btEqualOnMouseClick();
        }
        if(key.getCode()==KeyCode.SUBTRACT || key.getCode()==KeyCode.MINUS){
            this.btSubtractOnMousePress();
            this.btSubtractOnMouseClick();
        }
        if (key.getCode()==KeyCode.DIVIDE){
            this.btDivideOnMousePress();
            this.btDivideOnMouseClick();
        }
        /*if (key.getCode()==KeyCode.E){
            mainService.intputNum(firstInput,secondInput,"E");
        }*/
        System.out.println(key.getCode());
    }
    @FXML
    private void keyRelease(KeyEvent key){
        if(key.getCode()==KeyCode.NUMPAD1 || key.getCode()==KeyCode.DIGIT1){
            this.bt1OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD2 || key.getCode()==KeyCode.DIGIT2){
            this.bt2OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD3 || key.getCode()==KeyCode.DIGIT3){
            this.bt3OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD4 || key.getCode()==KeyCode.DIGIT4){
            this.bt4OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD5 || key.getCode()==KeyCode.DIGIT5){
            this.bt5OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD6 || key.getCode()==KeyCode.DIGIT6){
            this.bt6OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD7 || key.getCode()==KeyCode.DIGIT7){
            this.bt7OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD8 || key.getCode()==KeyCode.DIGIT8){
            this.bt8OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD9 || key.getCode()==KeyCode.DIGIT9){
            this.bt9OnMouseExit();
        }
        if(key.getCode()==KeyCode.NUMPAD0 || key.getCode()==KeyCode.DIGIT0){
            this.bt0OnMouseExit();
        }
        if(key.getCode()==KeyCode.DECIMAL){
            this.btPointOnMouseExit();
        }
        if(key.getCode()==KeyCode.BACK_SPACE){
            this.btBackSpaceOnMouseExit();
        }
        if(key.getCode()==KeyCode.ADD){
            this.btAddOnMouseExit();
        }
        if(key.getCode()==KeyCode.MULTIPLY){
            this.btMultiplyOnMouseExit();
        }
        if(key.getCode()==KeyCode.DELETE){
            this.btCEOnMouseExit();
        }
        if(key.getCode()==KeyCode.ENTER){
            this.btEqualOnMouseExit();
        }
        if(key.getCode()==KeyCode.SUBTRACT){
            this.btSubtractOnMouseExit();
        }
        if (key.getCode()==KeyCode.DIVIDE){
            this.btDivideOnMouseExit();
        }
    }

    /**
     * 0
     * */
    @FXML
    private Button bt0;
    @FXML
    private void bt0OnMouseEnter() {
        bt0.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt0OnMouseExit() {
        bt0.setStyle(btStyleDefault);
    }
    @FXML
    private void bt0OnMouseClick(){
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"0");
    }
    @FXML
    private void bt0OnMousePress(){
        bt0.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt0OnMouseReleas(){
        bt0.setStyle(btStyleMouseEnter);
    }

    /**
     * 1
     * */
    @FXML
    private Button bt1;
    @FXML
    private void bt1OnMouseEnter() {
        bt1.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt1OnMouseExit() {
        bt1.setStyle(btStyleDefault);
    }
    @FXML
    private void bt1OnMouseClick(){
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"1");
    }
    @FXML
    private void bt1OnMousePress(){
        bt1.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt1OnMouseReleas(){
        bt1.setStyle(btStyleMouseEnter);
    }

    /**
     * 2
     * */
    @FXML
    private Button bt2;
    @FXML
    private void bt2OnMouseEnter() {
        bt2.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt2OnMouseExit() {
        bt2.setStyle(btStyleDefault);
    }
    @FXML
    private void bt2OnMouseClick(){
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"2");
    }
    @FXML
    private void bt2OnMousePress(){
        bt2.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt2OnMouseReleas(){
        bt2.setStyle(btStyleMouseEnter);
    }

    /**
     * 3
     * */
    @FXML
    private Button bt3;
    @FXML
    private void bt3OnMouseEnter() {
        bt3.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt3OnMouseExit() {
        bt3.setStyle(btStyleDefault);
    }
    @FXML
    private void bt3OnMouseClick(){
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"3");
    }
    @FXML
    private void bt3OnMousePress(){
        bt3.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt3OnMouseReleas(){
        bt3.setStyle(btStyleMouseEnter);
    }

    /**
     * 4
     * */
    @FXML
    private Button bt4;
    @FXML
    private void bt4OnMouseEnter() {
        bt4.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt4OnMouseExit() {
        bt4.setStyle(btStyleDefault);
    }
    @FXML
    private void bt4OnMouseClick() {
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"4");
    }
    @FXML
    private void bt4OnMousePress(){
        bt4.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt4OnMouseReleas(){
        bt4.setStyle(btStyleMouseEnter);
    }

    /**
     * 5
     * */
    @FXML
    private Button bt5;
    @FXML
    private void bt5OnMouseEnter() {
        bt5.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt5OnMouseExit() {
        bt5.setStyle(btStyleDefault);
    }
    @FXML
    private void bt5OnMouseClick(){
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"5");
    }
    @FXML
    private void bt5OnMousePress(){
        bt5.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt5OnMouseReleas(){
        bt5.setStyle(btStyleMouseEnter);
    }

    /**
     * 6
     * */
    @FXML
    private Button bt6;
    @FXML
    private void bt6OnMouseEnter() {
        bt6.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt6OnMouseExit() {
        bt6.setStyle(btStyleDefault);
    }
    @FXML
    private void bt6OnMouseClick() {
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"6");
    }
    @FXML
    private void bt6OnMousePress(){
        bt6.setStyle(btStyleMousePress);
    }
    @FXML
    protected void bt6OnMouseReleas(){
        bt6.setStyle(btStyleMouseEnter);
    }

    /**
     * 7
     * */
    @FXML
    private Button bt7;
    @FXML
    private void bt7OnMouseEnter() {
        bt7.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt7OnMouseExit() {
        bt7.setStyle(btStyleDefault);
    }
    @FXML
    private void bt7OnMouseClick(){
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"7");
    }
    @FXML
    private void bt7OnMousePress(){
        bt7.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt7OnMouseReleas(){
        bt7.setStyle(btStyleMouseEnter);
    }

    /**
     * 8
     * */
    @FXML
    private Button bt8;
    @FXML
    private void bt8OnMouseEnter() {
        bt8.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt8OnMouseExit() {
        bt8.setStyle(btStyleDefault);
    }
    @FXML
    private void bt8OnMouseClick(){
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"8");
    }
    @FXML
    private void bt8OnMousePress(){
        bt8.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt8OnMouseReleas(){
        bt8.setStyle(btStyleMouseEnter);
    }

    /**
     * 9
     * */
    @FXML
    private Button bt9;
    @FXML
    private void bt9OnMouseEnter() {
        bt9.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void bt9OnMouseExit() {
        bt9.setStyle(btStyleDefault);
    }
    @FXML
    private void bt9OnMouseClick(){
        if(!flagOperation)
            return;
        mainService.intputNum(firstInput,secondInput,"9");
    }
    @FXML
    private void bt9OnMousePress(){
        bt9.setStyle(btStyleMousePress);
    }
    @FXML
    private void bt9OnMouseReleas(){
        bt9.setStyle(btStyleMouseEnter);
    }

    /**
     * .号
     * */
    @FXML
    private Button btPoint;
    @FXML
    private void btPointOnMouseEnter() {
        btPoint.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btPointOnMouseExit() {
        btPoint.setStyle(btStyleDefault);
    }
    @FXML
    private void btPointOnMouseClick(){
        if(!flagOperation || !flagZero)
            return;
        mainService.intputNum(firstInput,secondInput,".");
    }
    @FXML
    private void btPointOnMousePress(){
        btPoint.setStyle(btStyleMousePress);
    }
    @FXML
    private void btPointOnMouseReleas(){
        btPoint.setStyle(btStyleMouseEnter);
    }

    /**
     * +/-号
     * */
    @FXML
    private Button btZf;
    @FXML
    private void btZfOnMouseEnter() {
        btZf.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btZfOnMouseExit() {
        btZf.setStyle(btStyleDefault);
    }
    @FXML
    private void btZfOnMouseClick(){
        if(!flagOperation || !flagZero)
            return;
        mainService.intputNum(firstInput,secondInput,"-");
    }
    @FXML
    private void btZfOnMousePress(){
        btZf.setStyle(btStyleMousePress);
    }
    @FXML
    private void btZfOnMouseReleas(){
        btZf.setStyle(btStyleMouseEnter);
    }

    //操作符
    /**
     * ←号
     * */
    @FXML
    private Button btBackSpace;
    @FXML
    private void btBackSpaceOnMouseEnter() {
        btBackSpace.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btBackSpaceOnMouseExit() {
        btBackSpace.setStyle(btStyleDefault);
    }
    @FXML
    private void btBackSpaceOnMouseClick(){
        if(!flagOperation || !flagZero)
            return;
        mainService.delete(firstInput,secondInput);
    }
    @FXML
    private void btBackSpaceOnMousePress(){
        btBackSpace.setStyle(btStyleMousePress);
    }
    @FXML
    private void btBackSpaceOnMouseReleas(){
        btBackSpace.setStyle(btStyleMouseEnter);
    }


    /**
     * +号
     * */
    @FXML
    private Button btAdd;
    @FXML
    private void btAddOnMouseEnter() {
        btAdd.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btAddOnMouseExit() {
        btAdd.setStyle(btStyleDefault);
    }
    @FXML
    private void btAddOnMouseClick(){
        if(!flagOperation || !flagZero)
            return;
        mainService.inputOp(firstInput,secondInput,"+");
    }
    @FXML
    private void btAddOnMousePress(){
        btAdd.setStyle(btStyleMousePress);
    }
    @FXML
    private void btAddOnMouseReleas(){
        btAdd.setStyle(btStyleMouseEnter);
    }

    /**
     * -号
     * */
    @FXML
    private Button btSubtract;
    @FXML
    private void btSubtractOnMouseEnter() {
        btSubtract.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btSubtractOnMouseExit() {
        btSubtract.setStyle(btStyleDefault);
    }
    @FXML
    private void btSubtractOnMouseClick(){
        if(!flagOperation || !flagZero)
            return;
        mainService.inputOp(firstInput,secondInput,"-");
    }
    @FXML
    private void btSubtractOnMousePress(){
        btSubtract.setStyle(btStyleMousePress);
    }
    @FXML
    private void btSubtractOnMouseReleas(){
        btSubtract.setStyle(btStyleMouseEnter);
    }

    /**
     * ×号
     * */
    @FXML
    private Button btMultiply;
    @FXML
    private void btMultiplyOnMouseEnter() {
        btMultiply.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btMultiplyOnMouseExit() {
        btMultiply.setStyle(btStyleDefault);
    }
    @FXML
    private void btMultiplyOnMouseClick(){
        if(!flagOperation || !flagZero)
            return;
        mainService.inputOp(firstInput,secondInput,"×");
    }
    @FXML
    private void btMultiplyOnMousePress(){
        btMultiply.setStyle(btStyleMousePress);
    }
    @FXML
    private void btMultiplyOnMouseReleas(){
        btMultiply.setStyle(btStyleMouseEnter);
    }

    /**
     * ÷号
     * */
    @FXML
    private Button btDivide;
    @FXML
    private void btDivideOnMouseEnter() {
        btDivide.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btDivideOnMouseExit() {
        btDivide.setStyle(btStyleDefault);
    }
    @FXML
    private void btDivideOnMouseClick(){
        if(!flagOperation || !flagZero)
            return;
        mainService.inputOp(firstInput,secondInput,"÷");
    }
    @FXML
    private void btDivideOnMousePress(){
        btDivide.setStyle(btStyleMousePress);
    }
    @FXML
    private void btDivideOnMouseReleas(){
        btDivide.setStyle(btStyleMouseEnter);
    }

    /**
     * =号
     * */
    @FXML
    private Button btEqual;
    @FXML
    private void btEqualOnMouseEnter() {
        btEqual.setStyle("-fx-background-color: rgba(25,106,167,0.91)");
    }
    @FXML
    private void btEqualOnMouseExit() {
        btEqual.setStyle("-fx-background-color: #196aa7");
    }
    @FXML
    private void btEqualOnMouseClick(){
        if(!flagOperation || !flagZero)
            return;
        mainService.equal(firstInput,secondInput);
    }
    @FXML
    private void btEqualOnMousePress(){
        btEqual.setStyle("-fx-background-color: rgba(25,106,167,0.77)");
    }
    @FXML
    private void btEqualOnMouseReleas(){
        btEqual.setStyle("-fx-background-color: rgba(25,106,167,0.91)");
    }


    /**
     * C号
     * */
    @FXML
    private Button btC;
    @FXML
    private void btCOnMouseEnter() {
        btC.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btCOnMouseExit() {
        btC.setStyle(btStyleDefault);
    }
    @FXML
    private void btCOnMouseClick(){
        if(!flagOperation)
            return;
        mainService.cFuntion(cService,firstInput,secondInput);
    }
    @FXML
    private void btCOnMousePress(){
        btC.setStyle(btStyleMousePress);
    }
    @FXML
    private void btCOnMouseReleas(){
        btC.setStyle(btStyleMouseEnter);
    }

    /**
     * CE号
     * */
    @FXML
    private Button btCE;
    @FXML
    private void btCEOnMouseEnter() {
        btCE.setStyle(btStyleMouseEnter);
    }
    @FXML
    private void btCEOnMouseExit() {
        btCE.setStyle(btStyleDefault);
    }
    @FXML
    private void btCEOnMouseClick(){
        if(!flagOperation)
            return;
        mainService.ceFuntion(cService,firstInput,secondInput);
    }
    @FXML
    private void btCEOnMousePress(){
        btCE.setStyle(btStyleMousePress);
    }
    @FXML
    private void btCEOnMouseReleas(){
        btCE.setStyle(btStyleMouseEnter);
    }

    @FXML
    Button btHis;
    @FXML
    private void btHisOnMouseEnter() {
        btHis.setStyle("-fx-background-color: #eaeaea");
    }
    @FXML
    private void btHisOnMouseExit() {
        btHis.setStyle("-fx-background-color: #ffffff");
    }
    @FXML
    private void btHisOnMouseClick(){
        if(!flagOperation)
            return;
        mainService.rollBackSelect(firstInput,secondInput);
    }
    @FXML
    private void btHisOnMousePress(){
        btHis.setStyle("-fx-background-color: #c7c7c7");
    }
    @FXML
    private void btHisOnMouseReleas(){
        btHis.setStyle("-fx-background-color: #eaeaea");
    }

    @FXML
    Button btAuthor;
    @FXML
    private void btAuthorOnMouseEnter() {
        btAuthor.setStyle("-fx-background-color: #eaeaea");
    }
    @FXML
    private void btAuthorOnMouseExit() {
        btAuthor.setStyle("-fx-background-color: #ffffff");
    }
    @FXML
    private void btAuthorOnMouseClick(){
        if(!flagOperation)
            return;
        Alert alert=new Alert(Alert.AlertType.INFORMATION,"作者：赖永超");
        alert.showAndWait();
    }
    @FXML
    private void btAuthorOnMousePress(){
        btAuthor.setStyle("-fx-background-color: #c7c7c7");
    }
    @FXML
    private void btAuthorOnMouseReleas(){
        btAuthor.setStyle("-fx-background-color: #eaeaea");
    }

    public void setFlagOperation(boolean x){
        this.flagOperation=x;
    }
    public void setFlagZero(boolean x){
        this.flagZero=x;
    }
}