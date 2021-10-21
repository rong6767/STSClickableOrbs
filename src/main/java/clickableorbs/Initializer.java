package clickableorbs;

import basemod.BaseMod;
import basemod.interfaces.*;
import clickableorbs.cards.*;
import clickableorbs.cards.OrbSkill;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

@SpireInitializer
public class Initializer implements
        EditCardsSubscriber
         {

    //Used by @SpireInitializer
    public static void initialize(){
        Initializer initializer = new Initializer();
    }

    public Initializer() {
        BaseMod.subscribe(this);
    }


    @Override
    public void receiveEditCards() {
        BaseMod.addCard(new OrbSkill());
    }




}
