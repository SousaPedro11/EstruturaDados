package estruturadados.anotacao;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anota��o criada para atribuir no ToString().
 *
 * @author Pedro Sousa
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AtribuirToString {

	String prefixo() default "";

	String sufixo() default "";
}
