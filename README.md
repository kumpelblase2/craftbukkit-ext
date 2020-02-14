# craftbukkit-ext

Since method names change between minecraft releases when accessing the methods provided by the native minecraft server package, 
this project tries to provide a consistent interface across minecraft versions. To achieve that, [extension functions](https://kotlinlang.org/docs/reference/extensions.html) 
from Kotlin are used. So instead of `VillageDoor.d()` you can use `VillageDoor.position`, which makes it both easier to grasp 
what is being done as well as avoid having to update it every time as new minecraft release comes around.

It's goal is not to completely abstract away the NMS functionality; you'll still work with `EntityLiving`, `BlockPosition`, etc.
However, migrating those between versions is rather straight forward compared to methods/attributes as you'd have to inspect each
and every one of them every time they're used. This moves them to a single place which can be updated at once and all call sites
will automatically be updated atomically.

This project is mostly for use in Kotlin based projects but can be used from Java as well. It's not a goal to have a perfect
experience from both Kotlin _and_ Java, but it shouldn't be too hard to use it in the latter. So any simple improvements for the
latter side are also welcome, but don't have priority.

## Usage

To use this library, first include it in your gradle/maven dependencies using the appropriate methods as shown below. Please replace
`${minecraftVersion}` with the desired minecraft version and `${release}` with the release version of the library. Make sure you have the maven repository `https://dl.bintray.com/kumpelblase2/Libraries` added!

```xml
<dependency>
	<groupId>de.eternalwings.bukkit</group>
	<artifactId>ext</artifactId>
	<version>${minecraftVersion}-${release}</version>
</dependency>
```

```groovy
implementation "de.eternalwings.bukkit:craftbukkit-ext:${minecraftVersion}-${release}"
```

The version scheme is chosen because by the very nature of this library it is mostly connected to the minecraft version. However,
to allow for additions to the library, there is another additional version string added to the end, which is a simple counter.

Once that is done, your IDE should automatically provide the suggestions for methods defined on NMS classes. such as 
`Vec3D.multiply(double)`. To use them in Java you can access them via the following format `<NMSType>ExtKt.<method>`,
so for example `Vec3DExtKt.multiply(double)`.

### Examples

To illustrate why someone would want to use this, take the example provided below. It shows first how I would need to write code
if I just accessed the methods on the NMS entities directly. Below that is the same code, but using the extensions provided by 
this library.

```kotlin
val entity: EntityLiving = //...
val golem: EntityIronGolem = //...

if(entity is EntityInsentinent) {
  entity.controllerLook.a(golem, 30f, 30f)
}
if(golem.dz() == flowerTick) {
  if(entity is EntityInsentinent) {
    entity.navigation.a(golem, 1.0)
    isMoving = true
  }

  if(isMoving && entity.h(golem) < 4) {
    golem.a(false)
    if(entity is EntityInsentinent) {
      entity.navigation.q()
    }
  }
}
```

```kotlin
val entity: EntityLiving = //...
val golem: EntityIronGolem = //...

entity.getControllerLook()?.lookAt(golem, 30f, 30f)
if (targetGolem.roseHoldTicks == flowerTick) {
  entity.getNavigation()?.createPathToWithSpeed(golem, 1.0)
  isMoving = true
}

if (isMoving && entity.distanceSquared(golem) < 4) {
  golem.isHoldingRose = false
  entity.getNavigation()?.clearPath()
}
```

While obviously it's a little more convoluted than it has to be (I specifically want to allow entity livings here but could 
obviously filter them out and just accept entity insentinent instead), but it still illustrates what this library provides.

