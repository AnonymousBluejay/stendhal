package games.stendhal.server.entity;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import games.stendhal.server.core.engine.SingletonRepository;
import games.stendhal.server.core.engine.StendhalRPZone;
import games.stendhal.server.entity.item.Corpse;
import games.stendhal.server.entity.item.Item;
import games.stendhal.server.entity.slot.PlayerSlot;
import games.stendhal.server.maps.MockStendlRPWorld;

import marauroa.common.Log4J;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.RPClass.ItemTestHelper;

public class RPEntityTest {

	private final class MockRPentity extends RPEntity {
		@Override
		protected void dropItemsOn(final Corpse corpse) {
			//do Nothing
			
		}

		@Override
		public void logic() {
			//do Nothing
			
		}
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Log4J.init();
		MockStendlRPWorld.get();
		ItemTestHelper.generateRPClasses();
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testApplydistanceattackModifiers() {
		
		final int damage = 100;
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 0), is(108));
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 1), is(105));
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 4), is(99));
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 9), is(88));
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 16), is(72));
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 25), is(52));
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 36), is(28));
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 49), is(0));
		assertThat(RPEntity.applyDistanceAttackModifiers(damage, 64), is(-33));
	}
	@Test
	public void testCalculateRiskForCanHit() {
		final RPEntity entity = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
			}

			@Override
			public void logic() {
				// do nothing
				
			}
		};
		int defenderDEF = 1;
		int attackerATK = 1;
		assertThat(entity.calculateRiskForCanHit(1, defenderDEF, attackerATK), is(19));
		assertThat(entity.calculateRiskForCanHit(2, defenderDEF, attackerATK), is(18));
		assertThat(entity.calculateRiskForCanHit(3, defenderDEF, attackerATK), is(17));
		assertThat(entity.calculateRiskForCanHit(4, defenderDEF, attackerATK), is(16));
		assertThat(entity.calculateRiskForCanHit(5, defenderDEF, attackerATK), is(15));
		assertThat(entity.calculateRiskForCanHit(6, defenderDEF, attackerATK), is(14));
		assertThat(entity.calculateRiskForCanHit(7, defenderDEF, attackerATK), is(13));
		assertThat(entity.calculateRiskForCanHit(8, defenderDEF, attackerATK), is(12));
		assertThat(entity.calculateRiskForCanHit(9, defenderDEF, attackerATK), is(11));
		assertThat(entity.calculateRiskForCanHit(10, defenderDEF, attackerATK), is(10));
		assertThat(entity.calculateRiskForCanHit(11, defenderDEF, attackerATK), is(9));
		assertThat(entity.calculateRiskForCanHit(12, defenderDEF, attackerATK), is(8));
		assertThat(entity.calculateRiskForCanHit(13, defenderDEF, attackerATK), is(7));
		assertThat(entity.calculateRiskForCanHit(14, defenderDEF, attackerATK), is(6));
		assertThat(entity.calculateRiskForCanHit(15, defenderDEF, attackerATK), is(5));
		assertThat(entity.calculateRiskForCanHit(16, defenderDEF, attackerATK), is(4));
		assertThat(entity.calculateRiskForCanHit(17, defenderDEF, attackerATK), is(3));
		assertThat(entity.calculateRiskForCanHit(18, defenderDEF, attackerATK), is(2));
		assertThat(entity.calculateRiskForCanHit(19, defenderDEF, attackerATK), is(1));
		assertThat(entity.calculateRiskForCanHit(20, defenderDEF, attackerATK), is(0));
		
		
		defenderDEF = 10;
		attackerATK = 5;
		assertThat(entity.calculateRiskForCanHit(1, defenderDEF, attackerATK), is(90));
		assertThat(entity.calculateRiskForCanHit(2, defenderDEF, attackerATK), is(80));
		assertThat(entity.calculateRiskForCanHit(3, defenderDEF, attackerATK), is(70));
		assertThat(entity.calculateRiskForCanHit(4, defenderDEF, attackerATK), is(60));
		assertThat(entity.calculateRiskForCanHit(5, defenderDEF, attackerATK), is(50));
		assertThat(entity.calculateRiskForCanHit(6, defenderDEF, attackerATK), is(40));
		assertThat(entity.calculateRiskForCanHit(7, defenderDEF, attackerATK), is(30));
		assertThat(entity.calculateRiskForCanHit(8, defenderDEF, attackerATK), is(20));
		assertThat(entity.calculateRiskForCanHit(9, defenderDEF, attackerATK), is(10));
		assertThat(entity.calculateRiskForCanHit(10, defenderDEF, attackerATK), is(0));
		assertThat(entity.calculateRiskForCanHit(11, defenderDEF, attackerATK), is(-10));
		assertThat(entity.calculateRiskForCanHit(12, defenderDEF, attackerATK), is(-20));
		assertThat(entity.calculateRiskForCanHit(13, defenderDEF, attackerATK), is(-30));
		assertThat(entity.calculateRiskForCanHit(14, defenderDEF, attackerATK), is(-40));
		assertThat(entity.calculateRiskForCanHit(15, defenderDEF, attackerATK), is(-50));
		assertThat(entity.calculateRiskForCanHit(16, defenderDEF, attackerATK), is(-60));
		assertThat(entity.calculateRiskForCanHit(17, defenderDEF, attackerATK), is(-70));
		assertThat(entity.calculateRiskForCanHit(18, defenderDEF, attackerATK), is(-80));
		assertThat(entity.calculateRiskForCanHit(19, defenderDEF, attackerATK), is(-90));
		assertThat(entity.calculateRiskForCanHit(20, defenderDEF, attackerATK), is(-100));
	}
	@Test
	public void testGetItemAtkforsimpleweapon() {
		final RPEntity entity = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
				
			}

			@Override
			public void logic() {
				// do nothing
				
			}
		};
		entity.addSlot(new PlayerSlot("lhand"));
		entity.addSlot(new PlayerSlot("rhand"));
		
		assertThat(entity.getItemAtk(), is(0f));
		final Item item = SingletonRepository.getEntityManager().getItem("dagger");
		entity.getSlot("lhand").add(item);
		assertThat(entity.getItemAtk(), is((float) item.getAttack()));		
		entity.getSlot("rhand").add(item);
		assertThat(entity.getItemAtk(), is((float) item.getAttack()));
		entity.getSlot("lhand").remove(item.getID());
		assertThat(entity.getItemAtk(), is((float) item.getAttack()));		
		
	}
	@Test
	public void testGetItemAtkforcheese() {
			
		final RPEntity entity = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
				
			}

			@Override
			public void logic() {
				// do nothing
				
			}
		};
		entity.addSlot(new PlayerSlot("lhand"));
		entity.addSlot(new PlayerSlot("rhand"));
		
		assertThat(entity.getItemAtk(), is(0f));
		final Item item = SingletonRepository.getEntityManager().getItem("cheese");
		entity.getSlot("lhand").add(item);
		assertThat(entity.getItemAtk(), is(0f));		
		entity.getSlot("rhand").add(item);
		assertThat(entity.getItemAtk(), is(0f));
		entity.getSlot("lhand").remove(item.getID());
		assertThat(entity.getItemAtk(), is(0f));
	}
	
	@Test
	public void testGetItemAtkforLeftandRightweaponCorrectlyWorn() {
		ItemTestHelper.generateRPClasses();
		final RPEntity entity = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
				
			}

			@Override
			public void logic() {
				// do nothing
				
			}
		};
		entity.addSlot(new PlayerSlot("lhand"));
		entity.addSlot(new PlayerSlot("rhand"));
		
		assertThat(entity.getItemAtk(), is(0f));
		final Item lefthanditem = SingletonRepository.getEntityManager().getItem("l hand sword");
		entity.getSlot("lhand").add(lefthanditem);
		assertThat(entity.getItemAtk(), is(0f));	

		final Item righthanditem = SingletonRepository.getEntityManager().getItem("r hand sword");
		entity.getSlot("rhand").add(righthanditem);
		assertThat(entity.getItemAtk(), is((float) (lefthanditem.getAttack() + righthanditem.getAttack())));
	}
	
	@Test
	public void testGetItemAtkforLeftandRightweaponIncorrectlyWorn() {
				
		ItemTestHelper.generateRPClasses();
		final RPEntity entity = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
				
			}

			@Override
			public void logic() {
				// do nothing
				
			}
		};
		entity.addSlot(new PlayerSlot("lhand"));
		entity.addSlot(new PlayerSlot("rhand"));
		
		assertThat(entity.getItemAtk(), is(0f));

		final Item lefthanditem = SingletonRepository.getEntityManager().getItem("l hand sword");
		entity.getSlot("rhand").add(lefthanditem);
		assertThat(entity.getItemAtk(), is(0f));		

		final Item righthanditem = SingletonRepository.getEntityManager().getItem("r hand sword");
		entity.getSlot("lhand").add(righthanditem);
		assertThat(entity.getItemAtk(), is(0f));
		
	}

	@Test
	public void testAttackCanHitreturnTruedamageZero() {
		MockStendlRPWorld.get();
		final StendhalRPZone zone = new StendhalRPZone("testzone");
		final RPEntity attacker = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing

			}

			@Override
			public boolean canHit(final RPEntity defender) {
				return true;
			}
			@Override
			public int damageDone(final RPEntity defender) {
				return 0;
			}

			@Override
			public void logic() {
				// do nothing

			}
		};
		final RPEntity defender = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
				
			}

			@Override
			public void logic() {
				// do nothing
				
			}
		};
		
		zone.add(attacker);
		zone.add(defender);
		
		
		attacker.setTarget(defender);
		defender.setHP(100);
		
		assertTrue(zone.has(defender.getID()));
		assertThat(defender.getHP(), greaterThan(0));
		assertFalse(attacker.has("damage"));
		
		assertFalse(attacker.attack());
		
		assertNotNull(attacker.getAttackTarget());
		assertTrue(attacker.has("damage"));
		assertThat("no damage done " , attacker.get("damage"), is("0"));
		}

	@Test
	public void testAttackCanHitreturnTruedamage30() {
		MockStendlRPWorld.get();
		final StendhalRPZone zone = new StendhalRPZone("testzone");
		final RPEntity attacker = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing

			}

			@Override
			public boolean canHit(final RPEntity defender) {
				return true;
			}
			@Override
			public int damageDone(final RPEntity defender) {
				return 30;
			}

			@Override
			public void logic() {
				// do nothing

			}
		};
		final RPEntity defender = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
				
			}

			@Override
			public void onDamaged(final Entity attacker, final int damage) {
				assertEquals(30, damage);
			}
			@Override
			public void logic() {
				// do nothing
				
			}
		};
		
		zone.add(attacker);
		zone.add(defender);
		
		
		attacker.setTarget(defender);
		defender.setHP(100);
		
		assertTrue(zone.has(defender.getID()));
		assertThat(defender.getHP(), greaterThan(0));
		assertFalse(attacker.has("damage"));
		
		assertTrue(attacker.attack());
		
		assertNotNull(attacker.getAttackTarget());
		assertTrue(attacker.has("damage"));
		assertThat("no damge done " , attacker.get("damage"), is("30"));
		}

	@Test
	public void testIsAttacking() {
		final StendhalRPZone zone = new StendhalRPZone("testzone");
		final RPEntity attacker = new MockRPentity();
		assertFalse("attacktarget = null", attacker.isAttacking());
		final RPEntity defender = new MockRPentity();
		
		zone.add(attacker);
		zone.add(defender);
		attacker.setTarget(defender);
		defender.setHP(1);
		assertTrue(attacker.isAttacking());
		defender.setHP(0);
		assertFalse(attacker.isAttacking());
		
	}
	
	@Test
	public void testSetXP() throws Exception {
		
		final RPEntity entity = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
				
			}

			@Override
			public void logic() {
				// do nothing
				
			}
		};
		entity.setXP(300);
		int oldXP = entity.getXP();
		entity.setXP(oldXP + Integer.MAX_VALUE);
		assertThat(entity.getXP(), is(oldXP));
	}
	
	@Test
	public void testaddXP() throws Exception {
		
		final RPEntity entity = new RPEntity() {

			@Override
			protected void dropItemsOn(final Corpse corpse) {
				// do nothing
				
			}

			@Override
			public void logic() {
				// do nothing
				
			}
		};
		entity.setXP(300);
		int oldXP = entity.getXP();
		entity.addXP(Integer.MAX_VALUE);
		assertThat(entity.getXP(), is(oldXP));
	}
	
}
