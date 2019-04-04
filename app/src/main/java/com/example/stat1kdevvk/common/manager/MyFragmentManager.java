package com.example.stat1kdevvk.common.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import com.example.stat1kdevvk.ui.activity.BaseActivity;
import com.example.stat1kdevvk.ui.fragment.BaseFragment;

import java.util.Stack;

public class MyFragmentManager {
    private static final int EMPTY_FRAGMENT_STACK_SIZE = 1;

    private Stack<BaseFragment> mFragmentStack = new Stack<>();

    private BaseFragment mCurrentFragment;

    public void setFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)) {
            FragmentTransaction fragmentTransaction = createAddTransaction(activity, fragment, false);
            fragmentTransaction.replace(containerId, fragment);
            commitAddTransaction(activity, fragment, fragmentTransaction, false);
        }
    }

    public void addFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerId) {
        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)) {
            FragmentTransaction fragmentTransaction = createAddTransaction(activity, fragment, true);
            fragmentTransaction.add(containerId, fragment);
            commitAddTransaction(activity, fragment, fragmentTransaction, true);
        }
    }


    private FragmentTransaction createAddTransaction(BaseActivity activity, BaseFragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();

        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getTag());
        }

        return fragmentTransaction;
    }

    private void commitAddTransaction(BaseActivity activity, BaseFragment fragment, FragmentTransaction transaction, boolean addToBackStack) {
        if (transaction != null) {
            mCurrentFragment = fragment;

            if (!addToBackStack) {
                mFragmentStack = new Stack<>();
            }

            mFragmentStack.add(fragment);

            commitTransaction(activity, transaction);
        }
    }

    public boolean removeCurrentFragment(BaseActivity activity) {
        return removeFragment(activity, mCurrentFragment);
    }

    public boolean removeFragment(BaseActivity activity, BaseFragment fragment) {
        boolean canRemove = fragment != null && mFragmentStack.size() > EMPTY_FRAGMENT_STACK_SIZE;

        if (canRemove) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

            mFragmentStack.pop();
            mCurrentFragment = mFragmentStack.lastElement();

            transaction.remove(fragment);
            commitTransaction(activity, transaction);
        }

        return canRemove;
    }

    private void commitTransaction(BaseActivity activity, FragmentTransaction transaction) {
        transaction.commit();

        activity.fragmentOnScreen(mCurrentFragment);
    }

    public boolean isAlreadyContains(BaseFragment baseFragment) {
        if (baseFragment == null) {
            return false;
        }

        return mCurrentFragment != null && mCurrentFragment.getClass().getName().equals(baseFragment.getClass().getName());
    }

    public Stack<BaseFragment> getFragmentStack() {
        return mFragmentStack;
    }

}
