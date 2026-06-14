nitial Requirements (Phase 1)

We run an e-commerce platform.

Customers can apply coupon codes during checkout.

Current requirements:

Functional
Customer can enter a coupon code.

Example:

FESTIVE10
System validates:
coupon exists
coupon is active
coupon is not expired
If valid → calculate discount.

Supported discount types:

FLAT
Example:
FLAT100
→ ₹100 off
PERCENTAGE
Example:
FESTIVE10
→ 10% off
Return:
original amount
discount amount
final amount
Constraints
Only one coupon can be applied.
Ignore user eligibility.
Ignore category restrictions.
Ignore usage limits.
Ignore DB.
Ignore API.

Focus only on domain model / LLD.

Interview expectation

I want:

Entities

Responsibilities

Class relations

Important methods

No need for full code.

No UML.

No patterns discussion initially.

When you finish, explain:

Why calculation lives there?
Why not elsewhere?

===============================================================================================


Requirement Evolution — Phase 2

Business changed.

New requirement:

Coupon Eligibility

Coupons can now have conditions.

Examples:

FESTIVE10
→ works only if order >= 500
VIP20
→ works only for VIP users

Rules:

Multiple conditions can exist.
ALL conditions must pass.
If any fails → coupon not applied.
Return failure reasons.

Examples:

Rejected:
- Order below 500
- User not VIP

Still:

Only one coupon
No stacking
Ignore DB

Question for candidate:

What new entities/classes appear?
What changes in existing classes?
Who owns evaluation?
How will failure reason return?

Don't code yet.

Model first.