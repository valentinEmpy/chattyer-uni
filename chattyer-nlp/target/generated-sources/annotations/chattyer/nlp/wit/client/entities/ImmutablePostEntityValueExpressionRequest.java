package chattyer.nlp.wit.client.entities;

import chattyer.nlp.wit.client.AbstractApplicationScopedWitRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link PostEntityValueExpressionRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutablePostEntityValueExpressionRequest.builder()}.
 */
@Generated(from = "PostEntityValueExpressionRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutablePostEntityValueExpressionRequest
    extends PostEntityValueExpressionRequest {
  private final String applicationId;
  private final String entityId;
  private final String entityValue;
  private final String expression;

  private ImmutablePostEntityValueExpressionRequest(ImmutablePostEntityValueExpressionRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.entityId = builder.entityId;
    this.entityValue = builder.entityValue;
    this.expression = builder.expression;
  }

  /**
   * @return The value of the {@code applicationId} attribute
   */
  @JsonProperty("applicationId")
  @JsonIgnore
  @Override
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * @return The value of the {@code entityId} attribute
   */
  @JsonProperty("entityId")
  @JsonIgnore
  @Override
  public String getEntityId() {
    return entityId;
  }

  /**
   * @return The value of the {@code entityValue} attribute
   */
  @JsonProperty("entityValue")
  @JsonIgnore
  @Override
  public String getEntityValue() {
    return entityValue;
  }

  /**
   * @return The value of the {@code expression} attribute
   */
  @JsonProperty("expression")
  @Override
  public String getExpression() {
    return expression;
  }

  /**
   * This instance is equal to all instances of {@code ImmutablePostEntityValueExpressionRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutablePostEntityValueExpressionRequest
        && equalTo((ImmutablePostEntityValueExpressionRequest) another);
  }

  private boolean equalTo(ImmutablePostEntityValueExpressionRequest another) {
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
   * Prints the immutable value {@code PostEntityValueExpressionRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "PostEntityValueExpressionRequest{"
        + "applicationId=" + applicationId
        + ", entityId=" + entityId
        + ", entityValue=" + entityValue
        + ", expression=" + expression
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "PostEntityValueExpressionRequest", generator = "Immutables")
  @Deprecated
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json extends PostEntityValueExpressionRequest {
    @Nullable String applicationId;
    @Nullable String entityId;
    @Nullable String entityValue;
    @Nullable String expression;
    @JsonProperty("applicationId")
    @JsonIgnore
    public void setApplicationId(String applicationId) {
      this.applicationId = applicationId;
    }
    @JsonProperty("entityId")
    @JsonIgnore
    public void setEntityId(String entityId) {
      this.entityId = entityId;
    }
    @JsonProperty("entityValue")
    @JsonIgnore
    public void setEntityValue(String entityValue) {
      this.entityValue = entityValue;
    }
    @JsonProperty("expression")
    public void setExpression(String expression) {
      this.expression = expression;
    }
    @Override
    public String getApplicationId() { throw new UnsupportedOperationException(); }
    @Override
    public String getEntityId() { throw new UnsupportedOperationException(); }
    @Override
    public String getEntityValue() { throw new UnsupportedOperationException(); }
    @Override
    public String getExpression() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutablePostEntityValueExpressionRequest fromJson(Json json) {
    ImmutablePostEntityValueExpressionRequest.Builder builder = ImmutablePostEntityValueExpressionRequest.builder();
    if (json.applicationId != null) {
      builder.applicationId(json.applicationId);
    }
    if (json.entityId != null) {
      builder.entityId(json.entityId);
    }
    if (json.entityValue != null) {
      builder.entityValue(json.entityValue);
    }
    if (json.expression != null) {
      builder.expression(json.expression);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutablePostEntityValueExpressionRequest ImmutablePostEntityValueExpressionRequest}.
   * <pre>
   * ImmutablePostEntityValueExpressionRequest.builder()
   *    .applicationId(String) // required {@link PostEntityValueExpressionRequest#getApplicationId() applicationId}
   *    .entityId(String) // required {@link PostEntityValueExpressionRequest#getEntityId() entityId}
   *    .entityValue(String) // required {@link PostEntityValueExpressionRequest#getEntityValue() entityValue}
   *    .expression(String) // required {@link PostEntityValueExpressionRequest#getExpression() expression}
   *    .build();
   * </pre>
   * @return A new ImmutablePostEntityValueExpressionRequest builder
   */
  public static ImmutablePostEntityValueExpressionRequest.Builder builder() {
    return new ImmutablePostEntityValueExpressionRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutablePostEntityValueExpressionRequest ImmutablePostEntityValueExpressionRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "PostEntityValueExpressionRequest", generator = "Immutables")
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
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.entities.PostEntityValueExpressionRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(PostEntityValueExpressionRequest instance) {
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
      if (object instanceof PostEntityValueExpressionRequest) {
        PostEntityValueExpressionRequest instance = (PostEntityValueExpressionRequest) object;
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
     * Initializes the value for the {@link PostEntityValueExpressionRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link PostEntityValueExpressionRequest#getEntityId() entityId} attribute.
     * @param entityId The value for entityId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityId(String entityId) {
      this.entityId = Objects.requireNonNull(entityId, "entityId");
      initBits &= ~INIT_BIT_ENTITY_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link PostEntityValueExpressionRequest#getEntityValue() entityValue} attribute.
     * @param entityValue The value for entityValue 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityValue(String entityValue) {
      this.entityValue = Objects.requireNonNull(entityValue, "entityValue");
      initBits &= ~INIT_BIT_ENTITY_VALUE;
      return this;
    }

    /**
     * Initializes the value for the {@link PostEntityValueExpressionRequest#getExpression() expression} attribute.
     * @param expression The value for expression 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder expression(String expression) {
      this.expression = Objects.requireNonNull(expression, "expression");
      initBits &= ~INIT_BIT_EXPRESSION;
      return this;
    }

    /**
     * Builds a new {@link ImmutablePostEntityValueExpressionRequest ImmutablePostEntityValueExpressionRequest}.
     * @return An immutable instance of PostEntityValueExpressionRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutablePostEntityValueExpressionRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutablePostEntityValueExpressionRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      if ((initBits & INIT_BIT_ENTITY_ID) != 0) attributes.add("entityId");
      if ((initBits & INIT_BIT_ENTITY_VALUE) != 0) attributes.add("entityValue");
      if ((initBits & INIT_BIT_EXPRESSION) != 0) attributes.add("expression");
      return "Cannot build PostEntityValueExpressionRequest, some of required attributes are not set " + attributes;
    }
  }
}
