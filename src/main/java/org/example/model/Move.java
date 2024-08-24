package org.example.model;

import org.example.model.card.ICard;

public record Move(ICard cardFrom, ICard cardMoved,
                   CardPlace placeTo, CardPlace placeFrom) {
}
