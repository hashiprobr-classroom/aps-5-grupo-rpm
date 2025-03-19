package br.edu.insper.desagil.aps5.prevgo;

public abstract class   Dialog extends Window {
    private Button acceptButton;
    private Button rejectButton;

    public Dialog() {
        super(0, 0, 320, 240);
        acceptButton = new Button(140, 200, new Label(5, 5, 75, 25, "Yes"), 5);
        rejectButton = new Button(230, 200, new Label(5, 5, 75, 25, "No"), 5);
    }

    public Button getAcceptButton() {
        return acceptButton;
    }

    public Button getRejectButton() {
        return rejectButton;
    }

    public abstract void onAccept();

    public abstract void onReject();
}
