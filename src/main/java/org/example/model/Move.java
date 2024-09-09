package org.example.model;

import org.example.model.card.ICard;

public record Move(ICard cardMoved, CardPlace placeFrom,
                   ICard cardTo, CardPlace placeTo) {
}
