Feature: Add Project

  Background:
    Given open login page
    When login with correct username propro.organav@gmail.com and password Lorl34715sgh1!

  Scenario Outline: Creation Project
    Given dashboard page is opened
    When user clicks on Add project
    Then project page is displayed
    When Send Name <text name>
    * Send Announcement <text announcement>
    * Send IsShouAnnouncement <choose IsShouAnnouncement>
    * Send Type Project <type project>
    * Send EnableTCApprovals <choose enableTCApprovals>
    When user clicks on button add project
    Then message Add project is displayed
    Examples:
      | text name   | text announcement   | choose IsShouAnnouncement | type project | choose enableTCApprovals |
      | "text name" | "text announcement" | "true"                    | 2            | "true"                   |