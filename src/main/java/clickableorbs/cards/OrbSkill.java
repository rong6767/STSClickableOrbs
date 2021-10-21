package clickableorbs.cards;

import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.defect.ChannelAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import clickableorbs.Initializer;
import clickableorbs.orbs.DefaultOrb;


public class OrbSkill extends CustomCard {


    public static final String ID = "OrbSkill";
    public static final String NAME = "Orb Skill";





    private static final int COST = 1;



    public OrbSkill() {
        super(ID, NAME, "images/cards/orb_skill.png", 0, "NONE", CardType.SKILL, CardColor.BLUE, CardRarity.COMMON, CardTarget.NONE);

    }

    // Actions the card should do.
    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {

        AbstractDungeon.actionManager.addToBottom(new ChannelAction(new DefaultOrb())); // Channel a Default Orb.

    }

    // Upgraded stats.
    @Override
    public void upgrade() {

    }
}