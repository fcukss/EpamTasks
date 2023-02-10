package com.epam.rd.autocode.startegy.cards;

import com.epam.rd.autocode.startegy.cards.Strategy.BridgeStrategy;
import com.epam.rd.autocode.startegy.cards.Strategy.ClassicPokerStrategy;
import com.epam.rd.autocode.startegy.cards.Strategy.FoolStrategy;
import com.epam.rd.autocode.startegy.cards.Strategy.TexasHoldemStrategy;

public class CardDealingStrategies {
    public static CardDealingStrategy texasHoldemCardDealingStrategy() {
        return new TexasHoldemStrategy();
    }

    public static CardDealingStrategy classicPokerCardDealingStrategy() {
        return new ClassicPokerStrategy();
    }

    public static CardDealingStrategy bridgeCardDealingStrategy(){
       return new BridgeStrategy();
    }

    public static CardDealingStrategy foolCardDealingStrategy(){
        return new FoolStrategy();
    }

}
