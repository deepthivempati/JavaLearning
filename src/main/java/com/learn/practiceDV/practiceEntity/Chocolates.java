package com.learn.practiceDV.practiceEntity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
class Chocolates {
    int kitKat;
    int dairyMilk;
    public void multiplyChocolates() {
        System.out.println(kitKat * dairyMilk);
    }
}
