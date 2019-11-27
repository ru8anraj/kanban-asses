package com.ru8anraj.kanban.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

/**
 * Ticket
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-27T15:43:52.640Z")

public class Ticket {
	@JsonProperty("id")
	private Long id = null;

	@JsonProperty("title")
	private String title = null;

	/**
	 * ticket status in the kanban
	 */
	public enum StatusEnum {
		BACKLOG("Backlog"),

		WORK_IN_PROGRESS("Work In Progress"),

		COMPLETED("Completed");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static StatusEnum fromValue(String text) {
			for (StatusEnum b : StatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("status")
	private StatusEnum status = null;

	@JsonProperty("assignedTo")
	private String assignedTo = null;

	@JsonProperty("createdOn")
	private String createdOn = null;

	public Ticket id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ticket title(String title) {
		this.title = title;
		return this;
	}

	/**
	 * Get title
	 * 
	 * @return title
	 **/
	@ApiModelProperty(example = "Create a Kanban Service", required = true, value = "")
	@NotNull

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Ticket status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * ticket status in the kanban
	 * 
	 * @return status
	 **/
	@ApiModelProperty(required = true, value = "ticket status in the kanban")
	@NotNull

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public Ticket assignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
		return this;
	}

	/**
	 * Get assignedTo
	 * 
	 * @return assignedTo
	 **/
	@ApiModelProperty(example = "Rubanraj", value = "")

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Ticket createdOn(String createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	/**
	 * Ticket creation date
	 * 
	 * @return createdOn
	 **/
	@ApiModelProperty(example = "2017-01-01", value = "Ticket creation date")

	@Valid

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Ticket ticket = (Ticket) o;
		return Objects.equals(this.id, ticket.id) && Objects.equals(this.title, ticket.title)
				&& Objects.equals(this.status, ticket.status) && Objects.equals(this.assignedTo, ticket.assignedTo)
				&& Objects.equals(this.createdOn, ticket.createdOn);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, status, assignedTo, createdOn);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Ticket {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    title: ").append(toIndentedString(title)).append("\n");
		sb.append("    status: ").append(toIndentedString(status)).append("\n");
		sb.append("    assignedTo: ").append(toIndentedString(assignedTo)).append("\n");
		sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
