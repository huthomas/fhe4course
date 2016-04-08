/**
 */
package at.example.calendar.ui.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see at.example.calendar.ui.model.ModelFactory
 * @model kind="package"
 * @generated
 */
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://at.example.calendar.ui/model";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "UI";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = at.example.calendar.ui.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link at.example.calendar.ui.model.impl.UICalendarImpl <em>UI Calendar</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.example.calendar.ui.model.impl.UICalendarImpl
	 * @see at.example.calendar.ui.model.impl.ModelPackageImpl#getUICalendar()
	 * @generated
	 */
	int UI_CALENDAR = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CALENDAR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CALENDAR__OBJECT = 1;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CALENDAR__EVENTS = 2;

	/**
	 * The number of structural features of the '<em>UI Calendar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CALENDAR_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>UI Calendar</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_CALENDAR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link at.example.calendar.ui.model.impl.UIEventImpl <em>UI Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see at.example.calendar.ui.model.impl.UIEventImpl
	 * @see at.example.calendar.ui.model.impl.ModelPackageImpl#getUIEvent()
	 * @generated
	 */
	int UI_EVENT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_EVENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_EVENT__OBJECT = 1;

	/**
	 * The number of structural features of the '<em>UI Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_EVENT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>UI Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UI_EVENT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link at.example.calendar.ui.model.UICalendar <em>UI Calendar</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Calendar</em>'.
	 * @see at.example.calendar.ui.model.UICalendar
	 * @generated
	 */
	EClass getUICalendar();

	/**
	 * Returns the meta object for the attribute '{@link at.example.calendar.ui.model.UICalendar#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.example.calendar.ui.model.UICalendar#getName()
	 * @see #getUICalendar()
	 * @generated
	 */
	EAttribute getUICalendar_Name();

	/**
	 * Returns the meta object for the attribute '{@link at.example.calendar.ui.model.UICalendar#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see at.example.calendar.ui.model.UICalendar#getObject()
	 * @see #getUICalendar()
	 * @generated
	 */
	EAttribute getUICalendar_Object();

	/**
	 * Returns the meta object for the reference list '{@link at.example.calendar.ui.model.UICalendar#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Events</em>'.
	 * @see at.example.calendar.ui.model.UICalendar#getEvents()
	 * @see #getUICalendar()
	 * @generated
	 */
	EReference getUICalendar_Events();

	/**
	 * Returns the meta object for class '{@link at.example.calendar.ui.model.UIEvent <em>UI Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>UI Event</em>'.
	 * @see at.example.calendar.ui.model.UIEvent
	 * @generated
	 */
	EClass getUIEvent();

	/**
	 * Returns the meta object for the attribute '{@link at.example.calendar.ui.model.UIEvent#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see at.example.calendar.ui.model.UIEvent#getName()
	 * @see #getUIEvent()
	 * @generated
	 */
	EAttribute getUIEvent_Name();

	/**
	 * Returns the meta object for the attribute '{@link at.example.calendar.ui.model.UIEvent#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Object</em>'.
	 * @see at.example.calendar.ui.model.UIEvent#getObject()
	 * @see #getUIEvent()
	 * @generated
	 */
	EAttribute getUIEvent_Object();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link at.example.calendar.ui.model.impl.UICalendarImpl <em>UI Calendar</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.example.calendar.ui.model.impl.UICalendarImpl
		 * @see at.example.calendar.ui.model.impl.ModelPackageImpl#getUICalendar()
		 * @generated
		 */
		EClass UI_CALENDAR = eINSTANCE.getUICalendar();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_CALENDAR__NAME = eINSTANCE.getUICalendar_Name();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_CALENDAR__OBJECT = eINSTANCE.getUICalendar_Object();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UI_CALENDAR__EVENTS = eINSTANCE.getUICalendar_Events();

		/**
		 * The meta object literal for the '{@link at.example.calendar.ui.model.impl.UIEventImpl <em>UI Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see at.example.calendar.ui.model.impl.UIEventImpl
		 * @see at.example.calendar.ui.model.impl.ModelPackageImpl#getUIEvent()
		 * @generated
		 */
		EClass UI_EVENT = eINSTANCE.getUIEvent();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_EVENT__NAME = eINSTANCE.getUIEvent_Name();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UI_EVENT__OBJECT = eINSTANCE.getUIEvent_Object();

	}

} //ModelPackage
