# Authorization Methods

1. Role-based Access Control (RBAC)

### Benefits

- Security. RBAC uses the principle of least privilege to lower the risk of a data breach. It also limits damage should
  a breach occur.
- Ease of Use. RBAC connects employees to the data and systems they need and reduces administrative overhead for IT.
- Compliance Readiness. Administrators can more easily prove that data and sensitive information have been handled
  according to privacy, security, and confidentiality standards.

### Drawbacks

- Requires collaborations with across departments
- Admin may assign people to ill-fitting roles, add new "custom" role contrary to policy
- Leads to privilege creep, role explosion and security gaps

<br>

2. Policy-based Access Control (PBAC)

### Benefits

- Flexibility. Admins can generate policies that allow access to be fine- or coarse-grained.
- Speed. PBAC lets you quickly add, remove, or amend permissions.
- Adaptability. Policies address environmental and contextual controls (e.g., time- or location-bound access).
- Observability. Human-readable policies provide visibility into the relationship between identities and resources.\


### Difference to RBAC

- RBAC is more grainted and static, limits authorization based on the user's role and may lead to Role Explosion.
- PBAC has flexibility to be fine grained or coarse grained



<br>

3. Attribute-based Access Control (ABAC)

### Benefits

- Granularity. Because it uses attributes rather than roles to specify relationships between users and resources,
  administrators can create precisely targeted rules without needing to create additional roles.
- Flexibility. ABAC policies are easy to adapt as resources and users change. Rather than modifying rules or creating
  new roles, admins need only assign the relevant attributes to new users or resources.
- Adaptability. ABAC makes adding and revoking permissions easier by allowing admins to modify attributes. This
  simplifies onboarding and offboarding as well as the temporary provisioning of contractors and external partners.
- Security. ABAC allows admins to create context-sensitive rules as security needs arise so they can more easily protect
  user privacy and adhere to compliance requirements—without requiring a high degree of technical knowledge.

### Drawbacks

- Can be extended from RBAC, however takes time and effort, resources to implement

<br>
