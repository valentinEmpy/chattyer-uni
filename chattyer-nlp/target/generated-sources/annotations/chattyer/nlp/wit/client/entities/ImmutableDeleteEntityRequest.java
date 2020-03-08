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
 * Immutable implementation of {@link DeleteEntityRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDeleteEntityRequest.builder()}.
 */
@Generated(from = "DeleteEntityRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableDeleteEntityRequest extends DeleteEntityRequest {
  private final String applicationId;
  private final String entityId;

  private ImmutableDeleteEntityRequest(ImmutableDeleteEntityRequest.Builder builder) {
    this.applicationId = builder.applicationId;
    this.entityId = builder.entityId;
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
   * This instance is equal to all instances of {@code ImmutableDeleteEntityRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDeleteEntityRequest
        && equalTo((ImmutableDeleteEntityRequest) another);
  }

  private boolean equalTo(ImmutableDeleteEntityRequest another) {
    return applicationId.equals(another.applicationId)
        && entityId.equals(another.entityId);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}, {@code entityId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    h += (h << 5) + entityId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code DeleteEntityRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "DeleteEntityRequest{"
        + "applicationId=" + applicationId
        + ", entityId=" + entityId
        + "}";
  }

  /**
   * Creates a builder for {@link ImmutableDeleteEntityRequest ImmutableDeleteEntityRequest}.
   * <pre>
   * ImmutableDeleteEntityRequest.builder()
   *    .applicationId(String) // required {@link DeleteEntityRequest#getApplicationId() applicationId}
   *    .entityId(String) // required {@link DeleteEntityRequest#getEntityId() entityId}
   *    .build();
   * </pre>
   * @return A new ImmutableDeleteEntityRequest builder
   */
  public static ImmutableDeleteEntityRequest.Builder builder() {
    return new ImmutableDeleteEntityRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDeleteEntityRequest ImmutableDeleteEntityRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "DeleteEntityRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private static final long INIT_BIT_ENTITY_ID = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String applicationId;
    private @Nullable String entityId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.entities.DeleteEntityRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DeleteEntityRequest instance) {
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
      if (object instanceof DeleteEntityRequest) {
        DeleteEntityRequest instance = (DeleteEntityRequest) object;
        entityId(instance.getEntityId());
      }
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link DeleteEntityRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link DeleteEntityRequest#getEntityId() entityId} attribute.
     * @param entityId The value for entityId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityId(String entityId) {
      this.entityId = Objects.requireNonNull(entityId, "entityId");
      initBits &= ~INIT_BIT_ENTITY_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableDeleteEntityRequest ImmutableDeleteEntityRequest}.
     * @return An immutable instance of DeleteEntityRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDeleteEntityRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableDeleteEntityRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      if ((initBits & INIT_BIT_ENTITY_ID) != 0) attributes.add("entityId");
      return "Cannot build DeleteEntityRequest, some of required attributes are not set " + attributes;
    }
  }
}
