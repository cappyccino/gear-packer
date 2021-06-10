require 'capybara/dsl'
require 'capybara/rspec'

Capybara.current_driver = :selenium_headless
Capybara.app_host = 'localhost:9000'
Capybara.run_server = false

feature 'the home page' do
  before :each do
    visit '/'
  end

  it 'displays the title bar' do
    expect(page).to have_content 'Gear Packer'
  end
end
