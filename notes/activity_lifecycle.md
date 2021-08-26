# Stages Of Activity Lifecycle

The activity lifecycle is the set of states an activity can be in during its lifetime. The lifecycle extends from when the activity is initially created to when it is destroyed and the system reclaims that activity's resources. As a user navigates between activities in your app (and into and out of your app), those activities each transition between different states in the activity lifecycle.

As an Android developer, you need to understand the activity lifecycle. If your activities do not correctly respond to lifecycle state changes, your app could generate strange bugs, confusing behavior for your users, or use too many Android system resources. Understanding the Android lifecycle, and responding correctly to lifecycle state changes, is critical to being a good Android citizen.

Every activity has what is known as a lifecycle. This is an allusion to plant and animal lifecycles, like the lifecycle of this butterfly—the different states of the butterfly show its growth from birth to fully formed adulthood to death.

![butterfly lifecycle](/notes/butterfly.png)

Similarly, the activity lifecycle is made up of the different states that an activity can go through, from when the activity is first initialized to when it is finally destroyed and its memory reclaimed by the system. As the user starts your app, navigates between activities, navigates inside and outside of your app, the activity changes state. The diagram below shows all the activity lifecycle states. As their names indicate, these states represent the status of the activity.


![activity lifecycle](/gdg_kotlin_course/notes/lifecycle.png)
