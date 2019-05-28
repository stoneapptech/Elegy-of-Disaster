package effect;

import pipe.Pipe;


public class DrawCard extends Effect {
    private Pipe subject;
    private int num;
    public DrawCard(int num, Pipe subject) {
        this.subject = subject;
        this.num = num;
    }

    @Override
    public String getDescription() {
        return "抽取" + num + "張卡片";
    }

    @Override
    public void invoke() {
        subject.drawCard(num);
    }
}
