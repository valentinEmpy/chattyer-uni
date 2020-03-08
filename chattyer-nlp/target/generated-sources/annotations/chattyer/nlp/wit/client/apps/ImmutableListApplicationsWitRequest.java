package chattyer.nlp.wit.client.apps;

import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link ListApplicationsWitRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableListApplicationsWitRequest.builder()}.
 */
@Generated(from = "ListApplicationsWitRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableListApplicationsWitRequest
    extends ListApplicationsWitRequest {
  private final long offset;

  private ImmutableListApplicationsWitRequest(ImmutableListApplicationsWitRequest.Builder builder) {
    this.offset = builder.offsetIsSet()
        ? builder.offset
        : super.getOffset();
  }

  /**
   * @return The value of the {@code offset} attribute
   */
  @Override
  public long getOffset() {
    return offset;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableListApplicationsWitRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableListApplicationsWitRequest
        && equalTo((ImmutableListApplicationsWitRequest) another);
  }

  private boolean equalTo(ImmutableListApplicationsWitRequest another) {
    return offset == another.offset;
  }

  /**
   * Computes a hash code from attributes: {@code offset}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + Long.hashCode(offset);
    return h;
  }

  /**
   * Prints the immutable value {@code ListApplicationsWitRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ListApplicationsWitRequest{"
        + "offset=" + offset
        + "}";
  }

  /**
   * Creates a builder for {@link ImmutableListApplicationsWitRequest ImmutableListApplicationsWitRequest}.
   * <pre>
   * ImmutableListApplicationsWitRequest.builder()
   *    .offset(long) // optional {@link ListApplicationsWitRequest#getOffset() offset}
   *    .build();
   * </pre>
   * @return A new ImmutableListApplicationsWitRequest builder
   */
  public static ImmutableListApplicationsWitRequest.Builder builder() {
    return new ImmutableListApplicationsWitRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableListApplicationsWitRequest ImmutableListApplicationsWitRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "ListApplicationsWitRequest", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long OPT_BIT_OFFSET = 0x1L;
    private long optBits;

    private long offset;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ListApplicationsWitRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ListApplicationsWitRequest instance) {
      Objects.requireNonNull(instance, "instance");
      offset(instance.getOffset());
      return this;
    }

    /**
     * Initializes the value for the {@link ListApplicationsWitRequest#getOffset() offset} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link ListApplicationsWitRequest#getOffset() offset}.</em>
     * @param offset The value for offset 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder offset(long offset) {
      this.offset = offset;
      optBits |= OPT_BIT_OFFSET;
      return this;
    }

    /**
     * Builds a new {@link ImmutableListApplicationsWitRequest ImmutableListApplicationsWitRequest}.
     * @return An immutable instance of ListApplicationsWitRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableListApplicationsWitRequest build() {
      return new ImmutableListApplicationsWitRequest(this);
    }

    private boolean offsetIsSet() {
      return (optBits & OPT_BIT_OFFSET) != 0;
    }
  }
}
