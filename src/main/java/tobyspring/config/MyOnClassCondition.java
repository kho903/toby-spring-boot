package tobyspring.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;

public class MyOnClassCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		MultiValueMap<String, Object> attrs = metadata.getAllAnnotationAttributes(
			ConditionalMyOnClass.class.getName());
		String value = (String)attrs.get("value").get(0);
		return ClassUtils.isPresent(value, context.getClassLoader());
	}
}
