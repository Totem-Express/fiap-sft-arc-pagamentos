package br.com.fiap.totem_express_payments.shared.invariant;

public final class Invariant {
    public static <T> void of(T target, Rule<T>... rules){
        for (var rule: rules){
            if (rule.notValid(target))
                throw new InvariantException(rule.message(), target);
        }
    }
}
