package tn.esprit.backend.Dto;

import tn.esprit.backend.entities.Role;

public record SignUpDto (String firstName, String lastName, String login, char[] password, Role role){


}
