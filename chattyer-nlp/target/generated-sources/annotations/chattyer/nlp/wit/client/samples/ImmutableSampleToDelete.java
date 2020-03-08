package chattyer.nlp.wit.client.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link DeleteSampleRequest.SampleToDelete}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableSampleToDelete.builder()}.
 */
@Generated(from = "DeleteSampleRequest.SampleToDelete", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
public final class ImmutableSampleToDelete
    implements DeleteSampleRequest.SampleToDelete {
  private final String text;

  private ImmutableSampleToDelete(ImmutableSampleToDelete.Builder builder) {
    this.text = builder.text;
  }

  /**
   * @return The value of the {@code text} attribute
   */
  @Override
  public String getText() {
    return text;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableSampleToDelete} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableSampleToDelete
        && equalTo((ImmutableSampleToDelete) another);
  }

  private boolean equalTo(ImmutableSampleToDelete another) {
    return text.equals(another.text);
  }

  /**
   * Computes a hash code from attributes: {@code text}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + text.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code SampleToDelete} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "SampleToDelete{"
        + "text=" + text
        + "}";
  }

  /**
   * Creates a builder for {@link ImmutableSampleToDelete ImmutableSampleToDelete}.
   * <pre>
   * ImmutableSampleToDelete.builder()
   *    .text(String) // required {@link ImmutableSampleToDelete#getText() text}
   *    .build();
   * </pre>
   * @return A new ImmutableSampleToDelete builder
   */
  public static ImmutableSampleToDelete.Builder builder() {
    return new ImmutableSampleToDelete.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableSampleToDelete ImmutableSampleToDelete}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "DeleteSampleRequest.SampleToDelete", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_TEXT = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String text;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ImmutableSampleToDelete} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ImmutableSampleToDelete instance) {
      return from((DeleteSampleRequest.SampleToDelete) instance);
    }

    /**
     * Copy abstract value type {@code SampleToDelete} instance into builder.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    final Builder from(DeleteSampleRequest.SampleToDelete instance) {
      Objects.requireNonNull(instance, "instance");
      text(instance.getText());
      return this;
    }

    /**
     * Initializes the value for the {@link ImmutableSampleToDelete#getText() text} attribute.
     * @param text The value for text 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder text(String text) {
      this.text = Objects.requireNonNull(text, "text");
      initBits &= ~INIT_BIT_TEXT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableSampleToDelete ImmutableSampleToDelete}.
     * @return An immutable instance of SampleToDelete
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableSampleToDelete build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableSampleToDelete(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_TEXT) != 0) attributes.add("text");
      return "Cannot build SampleToDelete, some of required attributes are not set " + attributes;
    }
  }
}
