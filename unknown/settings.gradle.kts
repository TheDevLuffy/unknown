rootProject.name = "unknown"

include(
    ":application:app",
    ":application:consumer"
)

include(
    "integration:service",
)

include(
    ":core",
)

include(
    ":infrastructure:mongo",
    ":infrastructure:kafka",
)