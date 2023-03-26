let tabList = document.querySelectorAll('.tab-list');
let emailDashboard = document.querySelectorAll('.email-dashboard');
const tabs = document.querySelectorAll('[data-tab-target]');
const tabContent = document.querySelectorAll('[data-tab-content]');

function activeLink(event) {
  tabList.forEach((item) => {
    item.classList.remove('on');
  });
  this.classList.add('on');
}

tabs.forEach(tab => {
  tab.addEventListener('click', () => {
    const target = document.querySelector(tab.dataset.tabTarget);
    tabContent.forEach(tabc_all => {
      tabc_all.classList.add('off');
    });
    target.classList.remove('off');
  });
});

tabList.forEach((item) => {
  item.addEventListener('click', activeLink);
});