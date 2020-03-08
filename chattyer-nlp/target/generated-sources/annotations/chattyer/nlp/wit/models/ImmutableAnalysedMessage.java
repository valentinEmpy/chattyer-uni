package chattyer.nlp.wit.models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link AnalysedMessage}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableAnalysedMessage.builder()}.
 */
@Generated(from = "AnalysedMessage", generator = "Immutables")
@SuppressWarnings({"all"})
@ParametersAreNonnullByDefault
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public final class ImmutableAnalysedMessage implements AnalysedMessage {
  private final String messageId;
  private final String message;
  private final Map<String, List<AnalysedMessage.EntityValue>> entities;

  private ImmutableAnalysedMessage(ImmutableAnalysedMessage.Builder builder) {
    this.messageId = builder.messageId;
    this.message = builder.message;
    this.entities = createUnmodifiableMap(false, false, builder.entities);
  }

  /**
   * @return The value of the {@code messageId} attribute
   */
  @JsonProperty("msg_id")
  @Override
  public String getMessageId() {
    return messageId;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @JsonProperty("_text")
  @Override
  public String getMessage() {
    return message;
  }

  /**
   * @return The value of the {@code entities} attribute
   */
  @JsonProperty("entities")
  @Override
  public Map<String, List<AnalysedMessage.EntityValue>> getEntities() {
    return entities;
  }

  /**
   * This instance is equal to all instances of {@code ImmutableAnalysedMessage} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableAnalysedMessage
        && equalTo((ImmutableAnalysedMessage) another);
  }

  private boolean equalTo(ImmutableAnalysedMessage another) {
    return messageId.equals(another.messageId)
        && message.equals(another.message)
        && entities.equals(another.entities);
  }

  /**
   * Computes a hash code from attributes: {@code messageId}, {@code message}, {@code entities}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + messageId.hashCode();
    h += (h << 5) + message.hashCode();
    h += (h << 5) + entities.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code AnalysedMessage} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "AnalysedMessage{"
        + "messageId=" + messageId
        + ", message=" + message
        + ", entities=" + entities
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "AnalysedMessage", generator = "Immutables")
  @Deprecated
  @JsonDeserialize
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json implements AnalysedMessage {
    @Nullable String messageId;
    @Nullable String message;
    @Nullable Map<String, List<AnalysedMessage.EntityValue>> entities = Collections.emptyMap();
    @JsonProperty("msg_id")
    public void setMessageId(String messageId) {
      this.messageId = messageId;
    }
    @JsonProperty("_text")
    public void setMessage(String message) {
      this.message = message;
    }
    @JsonProperty("entities")
    public void setEntities(Map<String, List<AnalysedMessage.EntityValue>> entities) {
      this.entities = entities;
    }
    @Override
    public String getMessageId() { throw new UnsupportedOperationException(); }
    @Override
    public String getMessage() { throw new UnsupportedOperationException(); }
    @Override
    public Map<String, List<AnalysedMessage.EntityValue>> getEntities() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableAnalysedMessage fromJson(Json json) {
    ImmutableAnalysedMessage.Builder builder = ImmutableAnalysedMessage.builder();
    if (json.messageId != null) {
      builder.messageId(json.messageId);
    }
    if (json.message != null) {
      builder.message(json.message);
    }
    if (json.entities != null) {
      builder.putAllEntities(json.entities);
    }
    return builder.build();
  }

  /**
   * Creates a builder for {@link ImmutableAnalysedMessage ImmutableAnalysedMessage}.
   * <pre>
   * ImmutableAnalysedMessage.builder()
   *    .messageId(String) // required {@link AnalysedMessage#getMessageId() messageId}
   *    .message(String) // required {@link AnalysedMessage#getMessage() message}
   *    .entity|putAllEntities(String =&gt; List&amp;lt;chattyer.nlp.wit.models.AnalysedMessage.EntityValue&amp;gt;) // {@link AnalysedMessage#getEntities() entities} mappings
   *    .build();
   * </pre>
   * @return A new ImmutableAnalysedMessage builder
   */
  public static ImmutableAnalysedMessage.Builder builder() {
    return new ImmutableAnalysedMessage.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableAnalysedMessage ImmutableAnalysedMessage}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "AnalysedMessage", generator = "Immutables")
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_MESSAGE_ID = 0x1L;
    private static final long INIT_BIT_MESSAGE = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String messageId;
    private @Nullable String message;
    private Map<String, List<AnalysedMessage.EntityValue>> entities = new LinkedHashMap<String, List<AnalysedMessage.EntityValue>>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code AnalysedMessage} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(AnalysedMessage instance) {
      Objects.requireNonNull(instance, "instance");
      messageId(instance.getMessageId());
      message(instance.getMessage());
      putAllEntities(instance.getEntities());
      return this;
    }

    /**
     * Initializes the value for the {@link AnalysedMessage#getMessageId() messageId} attribute.
     * @param messageId The value for messageId 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("msg_id")
    public final Builder messageId(String messageId) {
      this.messageId = Objects.requireNonNull(messageId, "messageId");
      initBits &= ~INIT_BIT_MESSAGE_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link AnalysedMessage#getMessage() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("_text")
    public final Builder message(String message) {
      this.message = Objects.requireNonNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }

    /**
     * Put one entry to the {@link AnalysedMessage#getEntities() entities} map.
     * @param key The key in the entities map
     * @param value The associated value in the entities map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entity(String key, List<AnalysedMessage.EntityValue> value) {
      this.entities.put(
          Objects.requireNonNull(key, "entities key"),
          Objects.requireNonNull(value, "entities value"));
      return this;
    }

    /**
     * Put one entry to the {@link AnalysedMessage#getEntities() entities} map. Nulls are not permitted
     * @param entry The key and value entry
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entity(Map.Entry<String, ? extends List<AnalysedMessage.EntityValue>> entry) {
      String k = entry.getKey();
      List<AnalysedMessage.EntityValue> v = entry.getValue();
      this.entities.put(
          Objects.requireNonNull(k, "entities key"),
          Objects.requireNonNull(v, "entities value"));
      return this;
    }

    /**
     * Sets or replaces all mappings from the specified map as entries for the {@link AnalysedMessage#getEntities() entities} map. Nulls are not permitted
     * @param entries The entries that will be added to the entities map
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("entities")
    public final Builder entities(Map<String, ? extends List<AnalysedMessage.EntityValue>> entries) {
      this.entities.clear();
      return putAllEntities(entries);
    }

    /**
     * Put all mappings from the specified map as entries to {@link AnalysedMessage#getEntities() entities} map. Nulls are not permitted
     * @param entries The entries that will be added to the entities map
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder putAllEntities(Map<String, ? extends List<AnalysedMessage.EntityValue>> entries) {
      for (Map.Entry<String, ? extends List<AnalysedMessage.EntityValue>> e : entries.entrySet()) {
        String k = e.getKey();
        List<AnalysedMessage.EntityValue> v = e.getValue();
        this.entities.put(
            Objects.requireNonNull(k, "entities key"),
            Objects.requireNonNull(v, "entities value"));
      }
      return this;
    }

    /**
     * Builds a new {@link ImmutableAnalysedMessage ImmutableAnalysedMessage}.
     * @return An immutable instance of AnalysedMessage
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableAnalysedMessage build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableAnalysedMessage(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_MESSAGE_ID) != 0) attributes.add("messageId");
      if ((initBits & INIT_BIT_MESSAGE) != 0) attributes.add("message");
      return "Cannot build AnalysedMessage, some of required attributes are not set " + attributes;
    }
  }

  private static <K, V> Map<K, V> createUnmodifiableMap(boolean checkNulls, boolean skipNulls, Map<? extends K, ? extends V> map) {
    switch (map.size()) {
    case 0: return Collections.emptyMap();
    case 1: {
      Map.Entry<? extends K, ? extends V> e = map.entrySet().iterator().next();
      K k = e.getKey();
      V v = e.getValue();
      if (checkNulls) {
        Objects.requireNonNull(k, "key");
        Objects.requireNonNull(v, "value");
      }
      if (skipNulls && (k == null || v == null)) {
        return Collections.emptyMap();
      }
      return Collections.singletonMap(k, v);
    }
    default: {
      Map<K, V> linkedMap = new LinkedHashMap<>(map.size());
      if (skipNulls || checkNulls) {
        for (Map.Entry<? extends K, ? extends V> e : map.entrySet()) {
          K k = e.getKey();
          V v = e.getValue();
          if (skipNulls) {
            if (k == null || v == null) continue;
          } else if (checkNulls) {
            Objects.requireNonNull(k, "key");
            Objects.requireNonNull(v, "value");
          }
          linkedMap.put(k, v);
        }
      } else {
        linkedMap.putAll(map);
      }
      return Collections.unmodifiableMap(linkedMap);
    }
    }
  }
}
