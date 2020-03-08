package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link DeleteEntityValueExpressionRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDeleteEntityValueExpressionRequest.builder()}.
 */
@Generated(from = "DeleteEntityValueExpressionRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableDeleteEntityValueExpressionRequest
    extends DeleteEntityValueExpressionRequest {
  private final String applicationId;
  private final String entityId;
  private final String entityValue;
  private final String expression;

  private ImmutableDeleteEntityValueExpressionRequest(ImmutableDeleteEntityValueExpressionRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.entityId = builder.entityId;
    this.entityValue = builder.entityValue;
    this.expression = builder.expression;
  }

  /**
   * @return The value of the {@code applicationId} attribute
   */
  @Override
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * @return The value of the {@code entityId} attribute
   */
  @Override
  public String getEntityId() {
    return entityId;
  }

  /**
   * @return The value of the {@code entityValue} attribute
   */
  @Override
  public String getEntityValue() {
    return entityValue;
  }

  /**
   * @return The value of the {@code expression} attribute
   */
  @Override
  public String getExpression() {
    return expression;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDeleteEntityValueExpressionRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDeleteEntityValueExpressionRequest
        && equalTo((ImmutableDeleteEntityValueExpressionRequest) another);
  }

  private boolean equalTo(ImmutableDeleteEntityValueExpressionRequest another) {
    return applicationId.equals(another.applicationId)
        && entityId.equals(another.entityId)
        && entityValue.equals(another.entityValue)
        && expression.equals(another.expression);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code entityId}, {@code entityValue}, {@code expression}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + entityId.hashCode();
    h += (h << 5) + entityValue.hashCode();
    h += (h << 5) + expression.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code DeleteEntityValueExpressionRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "DeleteEntityValueExpressionRequest{"
        + "applicationId=" + applicationId
        + ", entityId=" + entityId
        + ", entityValue=" + entityValue
        + ", expression=" + expression
        + "}";
  }

  /**
   * Creates a builder for {@link ImmutableDeleteEntityValueExpressionRequest ImmutableDeleteEntityValueExpressionRequest}.
   * <pre>
   * ImmutableDeleteEntityValueExpressionRequest.builder()
   *    .applicationId(String) // required {@link DeleteEntityValueExpressionRequest#getApplicationId() applicationId}
   *    .entityId(String) // required {@link DeleteEntityValueExpressionRequest#getEntityId() entityId}
   *    .entityValue(String) // required {@link DeleteEntityValueExpressionRequest#getEntityValue() entityValue}
   *    .expression(String) // required {@link DeleteEntityValueExpressionRequest#getExpression() expression}
   *    .build();
   * </pre>
   * @return A new ImmutableDeleteEntityValueExpressionRequest builder
   */
  public static ImmutableDeleteEntityValueExpressionRequest.Builder builder() {
    return new ImmutableDeleteEntityValueExpressionRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDeleteEntityValueExpressionRequest ImmutableDeleteEntityValueExpressionRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "DeleteEntityValueExpressionRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private static final long INIT_BIT_ENTITY_ID = 0x2L;
    private static final long INIT_BIT_ENTITY_VALUE = 0x4L;
    private static final long INIT_BIT_EXPRESSION = 0x8L;
    private long initBits = 0xfL;

    private @Nullable String applicationId;
    private @Nullable String entityId;
    private @Nullable String entityValue;
    private @Nullable String expression;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.entities.DeleteEntityValueExpressionRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DeleteEntityValueExpressionRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AbstractApplicationScopedWitRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof DeleteEntityValueExpressionRequest) {
        DeleteEntityValueExpressionRequest instance = (DeleteEntityValueExpressionRequest) object;
        entityId(instance.getEntityId());
        entityValue(instance.getEntityValue());
        expression(instance.getExpression());
      }
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link DeleteEntityValueExpressionRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link DeleteEntityValueExpressionRequest#getEntityId() entityId} attribute.
     * @param entityId The value for entityId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityId(String entityId) {
      this.entityId = Objects.requireNonNull(entityId, "entityId");
      initBits &= ~INIT_BIT_ENTITY_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link DeleteEntityValueExpressionRequest#getEntityValue() entityValue} attribute.
     * @param entityValue The value for entityValue 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityValue(String entityValue) {
      this.entityValue = Objects.requireNonNull(entityValue, "entityValue");
      initBits &= ~INIT_BIT_ENTITY_VALUE;
      return this;
    }

    /**
     * Initializes the value for the {@link DeleteEntityValueExpressionRequest#getExpression() expression} attribute.
     * @param expression The value for expression 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder expression(String expression) {
      this.expression = Objects.requireNonNull(expression, "expression");
      initBits &= ~INIT_BIT_EXPRESSION;
      return this;
    }

    /**
     * Builds a new {@link ImmutableDeleteEntityValueExpressionRequest ImmutableDeleteEntityValueExpressionRequest}.
     * @return An immutable instance of DeleteEntityValueExpressionRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDeleteEntityValueExpressionRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableDeleteEntityValueExpressionRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      if ((initBits & INIT_BIT_ENTITY_ID) != 0) attributes.add("entityId");
      if ((initBits & INIT_BIT_ENTITY_VALUE) != 0) attributes.add("entityValue");
      if ((initBits & INIT_BIT_EXPRESSION) != 0) attributes.add("expression");
      return "Cannot build DeleteEntityValueExpressionRequest, some of required attributes are not set " + attributes;
    }
  }
}
