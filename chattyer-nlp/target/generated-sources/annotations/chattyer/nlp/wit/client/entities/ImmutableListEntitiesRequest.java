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
 * Immutable implementation of {@link ListEntitiesRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableListEntitiesRequest.builder()}.
 */
@Generated(from = "ListEntitiesRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableListEntitiesRequest extends ListEntitiesRequest {
  private final String applicationId;

  private ImmutableListEntitiesRequest(ImmutableListEntitiesRequest.Builder builder) {
    this.applicationId = builder.applicationId;
  }

  /**
   * @return The value of the {@code applicationId} attribute
   */
  @Override
  public String getApplicationId() {
    return applicationId;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableListEntitiesRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableListEntitiesRequest
        && equalTo((ImmutableListEntitiesRequest) another);
  }

  private boolean equalTo(ImmutableListEntitiesRequest another) {
    return applicationId.equals(another.applicationId);
  }

  /**
   * Computes a hash code from attributes: {@code applicationId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + applicationId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ListEntitiesRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ListEntitiesRequest{"
        + "applicationId=" + applicationId
        + "}";
  }

  /**
   * Creates a builder for {@link ImmutableListEntitiesRequest ImmutableListEntitiesRequest}.
   * <pre>
   * ImmutableListEntitiesRequest.builder()
   *    .applicationId(String) // required {@link ListEntitiesRequest#getApplicationId() applicationId}
   *    .build();
   * </pre>
   * @return A new ImmutableListEntitiesRequest builder
   */
  public static ImmutableListEntitiesRequest.Builder builder() {
    return new ImmutableListEntitiesRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableListEntitiesRequest ImmutableListEntitiesRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ListEntitiesRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_APPLICATION_ID = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String applicationId;

    private Builder() {
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

    /**
     * Fill a builder with attribute values from the provided {@code chattyer.nlp.wit.client.entities.ListEntitiesRequest} instance.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ListEntitiesRequest instance) {
      Objects.requireNonNull(instance, "instance");
      from((Object) instance);
      return this;
    }

    private void from(Object object) {
      if (object instanceof AbstractApplicationScopedWitRequest) {
        AbstractApplicationScopedWitRequest instance = (AbstractApplicationScopedWitRequest) object;
        applicationId(instance.getApplicationId());
      }
    }

    /**
     * Initializes the value for the {@link ListEntitiesRequest#getApplicationId() applicationId} attribute.
     * @param applicationId The value for applicationId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder applicationId(String applicationId) {
      this.applicationId = Objects.requireNonNull(applicationId, "applicationId");
      initBits &= ~INIT_BIT_APPLICATION_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableListEntitiesRequest ImmutableListEntitiesRequest}.
     * @return An immutable instance of ListEntitiesRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableListEntitiesRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableListEntitiesRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_APPLICATION_ID) != 0) attributes.add("applicationId");
      return "Cannot build ListEntitiesRequest, some of required attributes are not set " + attributes;
    }
  }
}
