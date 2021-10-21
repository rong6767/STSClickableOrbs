# STSClickableOrbs
This is a library for players to generate custom clickable orbs. It also supports arrow targets. 

## Custom Orb Example
```java
public class DefaultOrb extends CustomOrb implements ClickableOrb{ //please implement ClickableOrb interface

    @Override
    public void onStartOfTurn() {
        this.usedThisTurn = false; 
        this.isPlayerTurn = true;
    }
    @Override
    public void onEndOfTurn(){
        isPlayerTurn = false; // Not our turn now.
    }

    @Override
    public void onRightClick() {
        if ( this.usedThisTurn || !isPlayerTurn) {
            return; // Don't do anything.
        }

        if (AbstractDungeon.getCurrRoom() != null && AbstractDungeon.getCurrRoom().phase == AbstractRoom.RoomPhase.COMBAT) { // Only if you're in combat
            this.usedThisTurn = true;//set used true
            AbstractDungeon.actionManager.addToBottom(new PingAction(5));

        }
    }
}
```

## Custom Arrow Target Action Example
```java

public class PingAction extends AbstractGameAction implements TargetArrowScreen.TargetArrowScreenSubscriber {

    private int amt;

    public PingAction(int amt) {
        this.amt = amt;
        this.duration = DEFAULT_DURATION;
    }

    @Override
    public void update() {
        if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
            AbstractDungeon.actionManager.clearPostCombatActions();
            this.isDone = true;
        } else {
            if(this.duration == DEFAULT_DURATION) {
                TargetArrowScreen.Inst.open(this, "damage"+amt, true);

                this.tickDuration();
            }

            if(TargetArrowScreen.Inst.isActive && !TargetArrow.isActive) {
                this.isDone = true;
            }
        }
    }

    @Override
    public void receiveScreenTargetCreature(AbstractCreature source, AbstractCreature target) {
        addToBot(new DamageAction(target, new DamageInfo(AbstractDungeon.player, amt)));

        this.isDone = true;
    }
    @Override
    public void receiveEnd() {
        this.isDone = true;
    }
}
```
Full code can be found here:
- [Custom Orb](https://github.com/rong6767/STSClickableOrbs/blob/main/src/main/java/clickableorbs/orbs/DefaultOrb.java)
- [Arrow Action](https://github.com/rong6767/STSClickableOrbs/blob/main/src/main/java/clickableorbs/actions/PingAction.java)
